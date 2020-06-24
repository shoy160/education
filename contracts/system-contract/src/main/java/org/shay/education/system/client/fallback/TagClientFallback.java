package org.shay.education.system.client.fallback;

import org.shay.education.dto.PagedDTO;
import org.shay.education.system.client.TagClient;
import org.shay.education.system.dto.TagDTO;
import org.shay.education.system.dto.TagInputDTO;
import org.shay.education.system.enums.TagType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
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
    public int addTag(TagInputDTO dto) {
        logger.info("addTag fallback");
        return 0;
    }

    @Override
    public PagedDTO<TagDTO> getTags(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam(name = "type", required = false) TagType type
    ) {
        logger.info("getTags fallback");
        return new PagedDTO<>(0, new ArrayList<>());
    }
}
