package org.shay.education.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.shay.education.system.entity.SubjectTable;
import org.shay.education.system.mapper.SubjectMapper;
import org.shay.education.system.service.SubjectService;
import org.springframework.stereotype.Service;

/**
 * @author shay
 * @date 2020/6/24
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, SubjectTable> implements SubjectService {
}
