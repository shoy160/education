package org.shay.education.system.feign;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.shay.education.BaseClient;
import org.shay.education.dto.PagedDTO;
import org.shay.education.system.client.QuestionTypeClient;
import org.shay.education.system.dto.QuestionTypeDTO;
import org.shay.education.system.dto.SubjectDTO;
import org.shay.education.system.entity.QuestionTypeTable;
import org.shay.education.system.entity.SubjectTable;
import org.shay.education.system.service.QuestionTypeService;
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
public class QuestionTypeClientImpl extends BaseClient implements QuestionTypeClient {

    @Resource
    private QuestionTypeService service;

    @Override
    @GetMapping(API_PREFIX + "/{type}")
    public QuestionTypeDTO get(@PathVariable int type) {
        QuestionTypeTable model = service.getById(type);
        if (model == null) {
            return null;
        }
        return model.toDTO();
    }

    @Override
    @GetMapping(API_PREFIX)
    public PagedDTO<QuestionTypeDTO> paged(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        IPage<QuestionTypeTable> paged = new Page<>(page, size);
        QueryWrapper<QuestionTypeTable> wrapper = new QueryWrapper<>();

        paged = service.page(paged, wrapper);
        List<QuestionTypeTable> list = paged.getRecords();

        List<QuestionTypeDTO> dtoList = new ArrayList<>();
        for (QuestionTypeTable model : list) {
            QuestionTypeDTO dto = model.toDTO();
            dtoList.add(dto);
        }
        return new PagedDTO<>((int) paged.getTotal(), dtoList);
    }
}
