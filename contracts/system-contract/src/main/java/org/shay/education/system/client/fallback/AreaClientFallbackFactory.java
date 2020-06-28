package org.shay.education.system.client.fallback;

import feign.hystrix.FallbackFactory;
import org.shay.education.system.client.AreaClient;
import org.shay.education.system.dto.AreaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 区域服务 熔断
 *
 * @author shay
 */
@Component
public class AreaClientFallbackFactory implements FallbackFactory<AreaClient> {
    private final Logger logger;

    public AreaClientFallbackFactory() {
        logger = LoggerFactory.getLogger(AreaClientFallbackFactory.class);
    }

    @Override
    public AreaClient create(Throwable cause) {
        logger.error("area fallback", cause);
        return new AreaClient() {
            @Override
            public AreaDTO get(int code) {
                return null;
            }

            @Override
            public List<AreaDTO> getChildren(int parentCode) {
                return null;
            }
        };
    }
}
