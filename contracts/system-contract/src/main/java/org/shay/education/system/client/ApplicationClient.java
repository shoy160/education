package org.shay.education.system.client;

import org.shay.education.Constants;
import org.shay.education.dto.PagedDTO;
import org.shay.education.system.dto.ApplicationDTO;
import org.shay.education.system.dto.ApplicationInputDTO;
import org.shay.education.system.enums.ApplicationType;
import org.springframework.web.bind.annotation.*;

/**
 * 应用服务
 *
 * @author shay
 */
public interface ApplicationClient {
    String API_PREFIX = Constants.FEIGN_ROUTE_PREFIX + "application";

    /**
     * 获取应用信息
     *
     * @param id id
     * @return
     */
    @GetMapping(API_PREFIX + "/{id}")
    ApplicationDTO get(@PathVariable int id);

    /**
     * 创建应用
     *
     * @param dto
     * @return
     */
    @PostMapping(API_PREFIX)
    ApplicationDTO create(@RequestBody ApplicationInputDTO dto);

    /**
     * 应用列表
     *
     * @param page page
     * @param size size
     * @param type 应用类型
     * @return
     */
    @GetMapping(API_PREFIX)
    PagedDTO<ApplicationDTO> paged(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam(value = "type", required = false) ApplicationType type
    );
}
