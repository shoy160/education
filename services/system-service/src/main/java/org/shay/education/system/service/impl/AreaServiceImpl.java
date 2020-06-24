package org.shay.education.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.shay.education.system.entity.AreaTable;
import org.shay.education.system.mapper.AreaMapper;
import org.shay.education.system.service.AreaService;
import org.springframework.stereotype.Service;

/**
 * @author shay
 * @date 2020/6/24
 */
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, AreaTable> implements AreaService {
}
