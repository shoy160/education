package org.shay.education.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.shay.education.system.entity.TagTable;
import org.shay.education.system.mapper.TagMapper;
import org.shay.education.system.service.TagService;
import org.springframework.stereotype.Service;

/**
 * @author shay
 * @date 2020/6/8
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, TagTable> implements TagService {
}
