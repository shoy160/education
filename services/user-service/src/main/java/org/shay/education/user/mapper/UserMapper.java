package org.shay.education.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.shay.education.user.entity.UserTable;

/**
 * 用户数据层
 *
 * @author shay
 * @date 2020/6/9
 */
@Mapper
public interface UserMapper extends BaseMapper<UserTable> {
}
