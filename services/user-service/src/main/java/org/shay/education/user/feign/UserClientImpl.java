package org.shay.education.user.feign;

import org.shay.education.web.BaseClient;
import org.shay.education.dto.PagedDTO;
import org.shay.education.user.client.UserClient;
import org.shay.education.user.dto.UserDto;
import org.shay.education.user.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * @author shay
 * @date 2020/6/9
 */
@ApiIgnore
@RestController
@RequestMapping()
@Scope("prototype")
public class UserClientImpl extends BaseClient implements UserClient {

    @Resource
    private UserService userService;

    @Override
    @GetMapping(API_PREFIX)
    public PagedDTO<UserDto> search(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        return userService.search(page, size);
    }
}
