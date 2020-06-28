package org.shay.education.system.client;

import org.shay.education.Constants;
import org.shay.education.dto.PagedDTO;
import org.shay.education.system.client.fallback.SubjectClientFallbackFactory;
import org.shay.education.system.dto.SubjectDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 科目服务
 *
 * @author shay
 */
@FeignClient(
        value = Constants.APP_NAME_SYSTEM,
        fallbackFactory = SubjectClientFallbackFactory.class
)
public interface SubjectClient {
    String API_PREFIX = Constants.FEIGN_ROUTE_PREFIX + "subject";

    /**
     * 获取科目信息
     *
     * @param id 科目ID
     * @return
     */
    @GetMapping(API_PREFIX + "/{id}")
    SubjectDTO get(@PathVariable String id);

    /**
     * 科目列表
     *
     * @param page page
     * @param size size
     * @return
     */
    @GetMapping(API_PREFIX)
    PagedDTO<SubjectDTO> paged(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    );
}
