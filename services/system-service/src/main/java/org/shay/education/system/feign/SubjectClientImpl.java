package org.shay.education.system.feign;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.shay.education.BaseClient;
import org.shay.education.dto.PagedDTO;
import org.shay.education.system.client.SubjectClient;
import org.shay.education.system.dto.SubjectDTO;
import org.shay.education.system.dto.TagDTO;
import org.shay.education.system.entity.SubjectTable;
import org.shay.education.system.entity.TagTable;
import org.shay.education.system.service.SubjectService;
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
public class SubjectClientImpl extends BaseClient implements SubjectClient {

    @Resource
    private SubjectService service;

    @Override
    @GetMapping(API_PREFIX + "/{id}")
    public SubjectDTO get(@PathVariable String id) {
        SubjectTable model = service.getById(id);
        if (null == model) {
            return null;
        }
        return model.toDTO();
    }

    @Override
    @GetMapping(API_PREFIX)
    public PagedDTO<SubjectDTO> paged(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        IPage<SubjectTable> paged = new Page<>(page, size);
        QueryWrapper<SubjectTable> wrapper = new QueryWrapper<>();

        paged = service.page(paged, wrapper);
        List<SubjectTable> list = paged.getRecords();

        List<SubjectDTO> dtoList = new ArrayList<>();
        for (SubjectTable model : list) {
            SubjectDTO dto = model.toDTO();
            dtoList.add(dto);
        }
        return new PagedDTO<>((int) paged.getTotal(), dtoList);
    }
}
