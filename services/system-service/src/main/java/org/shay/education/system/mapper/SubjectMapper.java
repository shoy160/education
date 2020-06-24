package org.shay.education.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.shay.education.system.entity.SubjectTable;

/**
 * 科目mapper
 *
 * @author shay
 * @date 2020/6/24
 */
@Mapper
public interface SubjectMapper extends BaseMapper<SubjectTable> {
}
