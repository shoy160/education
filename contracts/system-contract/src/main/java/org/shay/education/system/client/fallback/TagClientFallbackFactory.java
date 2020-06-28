package org.shay.education.system.client.fallback;

import feign.hystrix.FallbackFactory;
import org.shay.education.dto.PagedDTO;
import org.shay.education.system.client.TagClient;
import org.shay.education.system.dto.TagDTO;
import org.shay.education.system.dto.TagInputDTO;
import org.shay.education.system.enums.TagType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author shay
 * @date 2020/6/8
 */
@Component
public class TagClientFallbackFactory implements FallbackFactory<TagClient> {
    private final Logger logger;

    public TagClientFallbackFactory() {
        logger = LoggerFactory.getLogger(TagClientFallbackFactory.class);
    }

    @Override
    public TagClient create(Throwable cause) {
        logger.error("tag fallback", cause);
        return new TagClient() {
            @Override
            public boolean addTag(TagInputDTO dto) {
                logger.info("addTag fallback");
                return false;
            }

            @Override
            public PagedDTO<TagDTO> getTags(int page, int size, TagType type) {
                logger.info("getTags fallback");
                return new PagedDTO<TagDTO>(0L, new ArrayList<>());
            }
        };
    }
}
