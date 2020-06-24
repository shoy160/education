package org.shay.education.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.shay.education.system.entity.QuestionTypeTable;

/**
 * 题型 mapper
 *
 * @author shay
 * @date 2020/6/24
 */
@Mapper
public interface QuestionTypeMapper extends BaseMapper<QuestionTypeTable> {
}
