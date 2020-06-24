package org.shay.education.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.shay.education.system.entity.TagTable;

/**
 * 标签mapper
 *
 * @author shay
 * @date 2020/6/8
 */
@Mapper
public interface TagMapper extends BaseMapper<TagTable> {
}
