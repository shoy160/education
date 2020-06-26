package org.shay.education.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.shay.education.dto.PagedDTO;
import org.shay.education.system.dto.SubjectDTO;
import org.shay.education.system.entity.SubjectTable;

/**
 * @author shay
 * @date 2020/6/24
 */
public interface SubjectService extends IService<SubjectTable> {
    /**
     * 分页查询
     *
     * @param page page
     * @param size size
     * @return
     */
    PagedDTO<SubjectDTO> paged(int page, int size);
}
