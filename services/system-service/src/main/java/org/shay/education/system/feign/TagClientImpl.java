package org.shay.education.system.feign;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.istack.internal.Nullable;
import org.shay.education.dto.PagedDto;
import org.shay.education.system.client.TagClient;
import org.shay.education.system.dto.TagDto;
import org.shay.education.system.dto.TagInputDto;
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
public class TagClientImpl implements TagClient {

    @Resource
    private TagService tagService;

    @Override
    @PostMapping(API_PREFIX)
    public int addTag(@RequestBody TagInputDto dto) {
        return 0;
    }

    @Override
    @GetMapping(API_PREFIX)
    public PagedDto<TagDto> getTags(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam(name = "type", required = false) TagType type
    ) {
        IPage<TagTable> tagPage = new Page<>(page, size);
        QueryWrapper<TagTable> wrapper = new QueryWrapper<>();
        if (type != null) {
            wrapper.lambda().eq(TagTable::getType, type.ordinal());
        }

        tagPage = tagService.page(tagPage, wrapper);

        List<TagTable> list = tagPage.getRecords();

        List<TagDto> dtoList = new ArrayList<>();
        for (TagTable tag : list) {
            TagDto dto = new TagDto();
            dto.setId(tag.getId());
            dto.setName(tag.getName());
            dto.setFullPinyin(tag.getFullPinyin());
            dto.setSimplePinyin(tag.getSimplePinyin());
            dto.setType(TagType.values()[tag.getType()]);
            dto.setCount(tag.getCount());
            dtoList.add(dto);
        }
        return new PagedDto<>((int) tagPage.getTotal(), dtoList);
    }
}
