package org.shay.education.system.client.fallback;

import org.shay.education.system.client.AreaClient;
import org.shay.education.system.dto.AreaDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 区域服务 熔断
 *
 * @author shay
 */
@Component
public class AreaClientFallback implements AreaClient {
    @Override
    public AreaDTO get(int code) {
        return null;
    }

    @Override
    public List<AreaDTO> getChildren(int parentCode) {
        return null;
    }
}
