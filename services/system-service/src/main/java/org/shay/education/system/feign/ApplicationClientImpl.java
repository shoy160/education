package org.shay.education.system.feign;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.shay.education.BaseClient;
import org.shay.education.dto.PagedDTO;
import org.shay.education.system.client.ApplicationClient;
import org.shay.education.system.dto.ApplicationDTO;
import org.shay.education.system.dto.ApplicationInputDTO;
import org.shay.education.system.dto.SubjectDTO;
import org.shay.education.system.entity.ApplicationTable;
import org.shay.education.system.entity.SubjectTable;
import org.shay.education.system.entity.TagTable;
import org.shay.education.system.enums.ApplicationType;
import org.shay.education.system.service.ApplicationService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shay
 * @date 2020/6/24
 */
@ApiIgnore
@RestController
@RequestMapping()
@Scope("prototype")
public class ApplicationClientImpl extends BaseClient implements ApplicationClient {
    @Resource
    private ApplicationService service;

    @Override
    @GetMapping(API_PREFIX + "/{id}")
    public ApplicationDTO get(@PathVariable int id) {
        ApplicationTable model = service.getById(id);
        if (model == null) {
            return null;
        }
        return model.toDTO();
    }

    @Override
    @PostMapping(API_PREFIX)
    public ApplicationDTO create(@RequestBody ApplicationInputDTO dto) {
        ApplicationTable model = new ApplicationTable();

        boolean result = service.save(model);
        if (result) {
            return model.toDTO();
        }
        return null;
    }

    @Override
    @GetMapping(API_PREFIX)
    public PagedDTO<ApplicationDTO> paged(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam(value = "type", required = false) ApplicationType type
    ) {
        IPage<ApplicationTable> paged = new Page<>(page, size);
        QueryWrapper<ApplicationTable> wrapper = new QueryWrapper<>();
        if (type != null) {
            wrapper.lambda().eq(ApplicationTable::getType, type.ordinal());
        }
        paged = service.page(paged, wrapper);
        List<ApplicationTable> list = paged.getRecords();

        List<ApplicationDTO> dtoList = new ArrayList<>();
        for (ApplicationTable model : list) {
            ApplicationDTO dto = model.toDTO();
            dtoList.add(dto);
        }
        return new PagedDTO<>((int) paged.getTotal(), dtoList);
    }
}
