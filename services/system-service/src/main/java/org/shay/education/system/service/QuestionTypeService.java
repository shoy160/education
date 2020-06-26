package org.shay.education.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.shay.education.dto.PagedDTO;
import org.shay.education.system.dto.QuestionTypeDTO;
import org.shay.education.system.entity.QuestionTypeTable;

/**
 * @author shay
 * @date 2020/6/24
 */
public interface QuestionTypeService extends IService<QuestionTypeTable> {

    /**
     * 分页查询
     *
     * @param page page
     * @param size size
     * @return
     */
    PagedDTO<QuestionTypeDTO> paged(int page, int size);
}
