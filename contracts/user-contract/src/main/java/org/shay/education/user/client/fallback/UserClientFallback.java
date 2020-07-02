package org.shay.education.user.client.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.shay.education.dto.PagedDTO;
import org.shay.education.user.client.UserClient;
import org.shay.education.user.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author shay
 * @date 2020/6/9
 */
@Slf4j
@Component
public class UserClientFallback implements FallbackFactory<UserClient> {

    @Override
    public UserClient create(Throwable cause) {
        log.error("user fallback", cause);
        return new UserClient() {
            @Override
            public PagedDTO<UserDTO> search(int page, int size) {
                return new PagedDTO<>(0L, new ArrayList<>());
            }
        };
    }
}
