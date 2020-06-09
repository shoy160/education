package org.shay.education.system.client.fallback;

import com.sun.istack.internal.Nullable;
import org.apache.commons.logging.LogFactory;
import org.shay.education.dto.PagedDto;
import org.shay.education.system.client.TagClient;
import org.shay.education.system.dto.TagDto;
import org.shay.education.system.dto.TagInputDto;
import org.shay.education.system.enums.TagType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * @author shay
 * @date 2020/6/8
 */
@Component
public class TagClientFallback implements TagClient {
    private Logger logger;

    public TagClientFallback() {
        logger = LoggerFactory.getLogger(TagClientFallback.class);
    }

    @Override
    public int addTag(TagInputDto dto) {
        logger.info("addTag fallback");
        return 0;
    }

    @Override
    public PagedDto<TagDto> getTags(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam(name = "type", required = false) TagType type
    ) {
        logger.info("getTags fallback");
        return new PagedDto<>(0, new ArrayList<>());
    }
}
