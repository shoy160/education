package org.shay.education.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.shay.education.system.entity.QuestionTypeTable;
import org.shay.education.system.mapper.QuestionTypeMapper;
import org.shay.education.system.service.QuestionTypeService;
import org.springframework.stereotype.Service;

/**
 * @author shay
 * @date 2020/6/24
 */
@Service
public class QuestionTypeServiceImpl extends ServiceImpl<QuestionTypeMapper, QuestionTypeTable> implements QuestionTypeService {
}
