package org.shay.education.user.client;

import org.shay.education.Constants;
import org.shay.education.dto.PagedDTO;
import org.shay.education.user.client.fallback.UserClientFallback;
import org.shay.education.user.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户服务
 *
 * @author shay
 * @date 2020/6/9
 */
@FeignClient(
        value = Constants.APP_NAME_USER,
        fallback = UserClientFallback.class
)
public interface UserClient {
    String API_PREFIX = Constants.FEIGN_ROUTE_PREFIX + "user";

    /**
     * 用户搜索
     *
     * @param page 分页
     * @param size 没有数量
     * @return 用户列表
     */
    @GetMapping(API_PREFIX)
    PagedDTO<UserDTO> search(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    );
}
