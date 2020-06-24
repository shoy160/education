package org.shay.education.system.client;

import org.shay.education.Constants;
import org.shay.education.system.client.fallback.AreaClientFallback;
import org.shay.education.system.client.fallback.TagClientFallback;
import org.shay.education.system.dto.AreaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 区域服务
 *
 * @author shay
 */

@FeignClient(
        value = Constants.APP_NAME_SYSTEM,
        fallback = AreaClientFallback.class
)
public interface AreaClient {
    String API_PREFIX = Constants.FEIGN_ROUTE_PREFIX + "area";

    /**
     * 获取区域信息
     *
     * @param code
     * @return
     */
    @GetMapping(API_PREFIX + "/{code}")
    AreaDTO get(@PathVariable int code);

    /**
     * 获取子集区域
     *
     * @param parentCode 父级编码,0:顶级
     * @return
     */
    @GetMapping(API_PREFIX + "/children/{parentCode}")
    List<AreaDTO> getChildren(@PathVariable int parentCode);
}
