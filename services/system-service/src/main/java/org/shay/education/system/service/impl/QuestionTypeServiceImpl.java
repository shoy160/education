package org.shay.education.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.shay.education.dto.PagedDTO;
import org.shay.education.system.dto.QuestionTypeDTO;
import org.shay.education.system.entity.QuestionTypeTable;
import org.shay.education.system.mapper.QuestionTypeMapper;
import org.shay.education.system.service.QuestionTypeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shay
 * @date 2020/6/24
 */
@Service
public class QuestionTypeServiceImpl extends ServiceImpl<QuestionTypeMapper, QuestionTypeTable> implements QuestionTypeService {
    @Override
    public PagedDTO<QuestionTypeDTO> paged(int page, int size) {
        IPage<QuestionTypeTable> paged = new Page<>(page, size);
        QueryWrapper<QuestionTypeTable> wrapper = new QueryWrapper<>();
        paged = page(paged, wrapper);
        List<QuestionTypeTable> list = paged.getRecords();

        List<QuestionTypeDTO> dtoList = new ArrayList<>();
        for (QuestionTypeTable model : list) {
            QuestionTypeDTO dto = model.toDTO();
            dtoList.add(dto);
        }
        return new PagedDTO<>((int) paged.getTotal(), dtoList);
    }
}
