package org.shay.education.system.client;

import org.shay.education.dto.PagedDTO;
import org.shay.education.system.client.fallback.TagClientFallbackFactory;
import org.shay.education.system.dto.TagDTO;
import org.shay.education.system.dto.TagInputDTO;
import org.shay.education.system.enums.TagType;
import org.shay.education.Constants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 标签服务
 *
 * @author shay
 * @date 2020/6/8
 */
@FeignClient(
        value = Constants.APP_NAME_SYSTEM,
        fallbackFactory = TagClientFallbackFactory.class
)
public interface TagClient {
    String API_PREFIX = Constants.FEIGN_ROUTE_PREFIX + "tag";

    /**
     * 添加标签
     *
     * @param dto
     * @return
     */
    @PostMapping(API_PREFIX)
    boolean addTag(@RequestBody TagInputDTO dto);

    /**
     * 获取标签
     *
     * @param type
     * @param page
     * @param size
     * @return
     */
    @GetMapping(API_PREFIX)
    PagedDTO<TagDTO> getTags(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam(name = "type", required = false) TagType type
    );
}
