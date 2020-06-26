package org.shay.education.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.shay.education.dto.PagedDTO;
import org.shay.education.system.dto.ApplicationDTO;
import org.shay.education.system.entity.ApplicationTable;
import org.shay.education.system.enums.ApplicationType;
import org.shay.education.system.mapper.ApplicationMapper;
import org.shay.education.system.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shay
 * @date 2020/6/24
 */
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, ApplicationTable> implements ApplicationService {
    @Override
    public PagedDTO<ApplicationDTO> paged(int page, int size, ApplicationType type) {
        IPage<ApplicationTable> paged = new Page<>(page, size);
        QueryWrapper<ApplicationTable> wrapper = new QueryWrapper<>();
        if (type != null) {
            wrapper.lambda().eq(ApplicationTable::getType, type.getValue());
        }
        wrapper.lambda().orderByAsc(ApplicationTable::getSort);
        paged = page(paged, wrapper);
        List<ApplicationTable> list = paged.getRecords();

        List<ApplicationDTO> dtoList = new ArrayList<>();
        for (ApplicationTable model : list) {
            ApplicationDTO dto = model.toDTO();
            dtoList.add(dto);
        }
        return new PagedDTO<>((int) paged.getTotal(), dtoList);
    }
}
