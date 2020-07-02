package org.shay.education.system.client.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Component
public class TagClientFallbackFactory implements FallbackFactory<TagClient> {

    @Override
    public TagClient create(Throwable cause) {
        log.error("tag fallback", cause);
        return new TagClient() {
            @Override
            public boolean addTag(TagInputDTO dto) {
                log.info("addTag fallback");
                return false;
            }

            @Override
            public PagedDTO<TagDTO> getTags(int page, int size, TagType type) {
                log.info("getTags fallback");
                return new PagedDTO<>(0L, new ArrayList<>());
            }
        };
    }
}
