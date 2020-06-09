package org.shay.education.system.client;

import com.sun.istack.internal.Nullable;
import org.shay.education.dto.PagedDto;
import org.shay.education.system.client.fallback.TagClientFallback;
import org.shay.education.system.dto.TagDto;
import org.shay.education.system.dto.TagInputDto;
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
        fallback = TagClientFallback.class
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
    int addTag(@RequestBody TagInputDto dto);

    /**
     * 获取标签
     *
     * @param type
     * @param page
     * @param size
     * @return
     */
    @GetMapping(API_PREFIX)
    PagedDto<TagDto> getTags(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam(name = "type", required = false) TagType type
    );
}
