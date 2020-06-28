package org.shay.education.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.shay.education.dto.PagedDTO;
import org.shay.education.system.dto.TagDTO;
import org.shay.education.system.entity.TagTable;
import org.shay.education.system.enums.TagType;
import org.shay.education.system.mapper.TagMapper;
import org.shay.education.system.service.TagService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shay
 * @date 2020/6/8
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, TagTable> implements TagService {
    @Override
    public PagedDTO<TagDTO> search(int page, int size, TagType type) {
        IPage<TagTable> tagPage = new Page<>(page, size);
        QueryWrapper<TagTable> wrapper = new QueryWrapper<>();
        if (type != null) {
            wrapper.lambda().eq(TagTable::getType, type.getValue());
        }

        tagPage = page(tagPage, wrapper);

        List<TagTable> list = tagPage.getRecords();

        List<TagDTO> dtoList = new ArrayList<>();
        for (TagTable tag : list) {
            TagDTO dto = tag.toDTO();
            dtoList.add(dto);
        }
        return new PagedDTO<>(tagPage.getTotal(), dtoList);
    }
}
