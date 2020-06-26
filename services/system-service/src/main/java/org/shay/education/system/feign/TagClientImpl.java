package org.shay.education.system.feign;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.shay.education.web.BaseClient;
import org.shay.education.dto.PagedDTO;
import org.shay.education.system.client.TagClient;
import org.shay.education.system.dto.TagDTO;
import org.shay.education.system.dto.TagInputDTO;
import org.shay.education.system.entity.TagTable;
import org.shay.education.system.enums.TagType;
import org.shay.education.system.service.TagService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shay
 * @date 2020/6/8
 */
@ApiIgnore
@RestController
@RequestMapping()
@Scope("prototype")
public class TagClientImpl extends BaseClient implements TagClient {

    @Resource
    private TagService tagService;

    @Override
    @PostMapping(API_PREFIX)
    public int addTag(@RequestBody TagInputDTO dto) {
        TagTable model = new TagTable();
        model.setName(dto.getName());
        model.setType(dto.getType().getValue());
        model.setCount(0);
        boolean result = tagService.save(model);
        return result ? 1 : 0;
    }

    @Override
    @GetMapping(API_PREFIX)
    public PagedDTO<TagDTO> getTags(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam(name = "type", required = false) TagType type
    ) {
        return tagService.paged(page, size, type);
    }
}
