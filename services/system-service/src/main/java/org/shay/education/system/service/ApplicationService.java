package org.shay.education.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.shay.education.dto.PagedDTO;
import org.shay.education.system.dto.ApplicationDTO;
import org.shay.education.system.entity.ApplicationTable;
import org.shay.education.system.enums.ApplicationType;

/**
 * @author shay
 * @date 2020/6/24
 */
public interface ApplicationService extends IService<ApplicationTable> {

    /**
     * 分页查询
     *
     * @param page page
     * @param size size
     * @param type 类型
     * @return
     */
    PagedDTO<ApplicationDTO> paged(int page, int size, ApplicationType type);
}
