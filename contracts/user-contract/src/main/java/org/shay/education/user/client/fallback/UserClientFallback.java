package org.shay.education.user.client.fallback;

import org.shay.education.dto.PagedDto;
import org.shay.education.user.client.UserClient;
import org.shay.education.user.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * @author shay
 * @date 2020/6/9
 */
public class UserClientFallback implements UserClient {
    private Logger logger;

    public UserClientFallback() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public PagedDto<UserDto> search(int page, int size) {
        logger.info("userClient search fallback");
        return new PagedDto<>(0, new ArrayList<>());
    }
}
