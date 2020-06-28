package org.shay.education.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.shay.education.dto.PagedDTO;
import org.shay.education.system.dto.SubjectDTO;
import org.shay.education.system.entity.SubjectTable;
import org.shay.education.system.mapper.SubjectMapper;
import org.shay.education.system.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shay
 * @date 2020/6/24
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, SubjectTable> implements SubjectService {
    @Override
    public PagedDTO<SubjectDTO> paged(int page, int size) {
        IPage<SubjectTable> paged = new Page<>(page, size);
        QueryWrapper<SubjectTable> wrapper = new QueryWrapper<>();

        paged = page(paged, wrapper);
        List<SubjectTable> list = paged.getRecords();

        List<SubjectDTO> dtoList = new ArrayList<>();
        for (SubjectTable model : list) {
            SubjectDTO dto = model.toDTO();
            dtoList.add(dto);
        }
        return new PagedDTO<>(paged.getTotal(), dtoList);
    }
}
