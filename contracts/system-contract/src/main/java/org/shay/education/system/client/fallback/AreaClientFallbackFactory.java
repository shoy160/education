package org.shay.education.system.client.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Component
public class AreaClientFallbackFactory implements FallbackFactory<AreaClient> {

    @Override
    public AreaClient create(Throwable cause) {
        log.error("area fallback", cause);
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
