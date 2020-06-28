package org.shay.education.system.client.fallback;

import feign.hystrix.FallbackFactory;
import org.shay.education.dto.PagedDTO;
import org.shay.education.system.client.SubjectClient;
import org.shay.education.system.dto.SubjectDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 科目服务 熔断
 *
 * @author shay
 */
@Component
public class SubjectClientFallbackFactory implements FallbackFactory<SubjectClient> {
    private final Logger logger;

    public SubjectClientFallbackFactory() {
        logger = LoggerFactory.getLogger(SubjectClientFallbackFactory.class);
    }

    @Override
    public SubjectClient create(Throwable cause) {
        logger.error("subject fallback", cause);
        return new SubjectClient() {
            @Override
            public SubjectDTO get(String id) {
                return null;
            }

            @Override
            public PagedDTO<SubjectDTO> paged(int page, int size) {
                return null;
            }
        };
    }
}
