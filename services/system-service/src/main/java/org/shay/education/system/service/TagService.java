package org.shay.education.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.shay.education.dto.PagedDTO;
import org.shay.education.system.dto.TagDTO;
import org.shay.education.system.entity.TagTable;
import org.shay.education.system.enums.TagType;

/**
 * @author shay
 * @date 2020/6/8
 */
public interface TagService extends IService<TagTable> {

    /**
     * 分页查询
     *
     * @param page page
     * @param size size
     * @param type 类型
     * @return
     */
    PagedDTO<TagDTO> paged(int page, int size, TagType type);
}
