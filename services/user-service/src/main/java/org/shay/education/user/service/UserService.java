package org.shay.education.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.shay.education.dto.PagedDto;
import org.shay.education.user.dto.UserDto;
import org.shay.education.user.entity.UserTable;

/**
 * @author shay
 * @date 2020/6/9
 */
public interface UserService extends IService<UserTable> {

    /**
     * 用户搜索
     *
     * @param page page
     * @param size size
     * @return 用户列表
     */
    PagedDto<UserDto> search(int page, int size);
}
