package org.shay.education.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.shay.education.dto.PagedDTO;
import org.shay.education.user.dto.UserDTO;
import org.shay.education.user.entity.UserTable;
import org.shay.education.user.mapper.UserMapper;
import org.shay.education.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shay
 * @date 2020/6/9
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserTable> implements UserService {
    @Override
    public PagedDTO<UserDTO> search(int page, int size) {
        Page<UserTable> userPage = new Page<>(page, size);
        LambdaQueryWrapper<UserTable> query = new LambdaQueryWrapper<>();
        userPage = page(userPage, query);
        long total = userPage.getTotal();
        List<UserDTO> dtoList = new ArrayList<>();
        for (UserTable user : userPage.getRecords()) {
            UserDTO dto = user.toDto();
            dtoList.add(dto);
        }
        return new PagedDTO<>((int) total, dtoList);
    }
}
