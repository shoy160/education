package org.shay.education.user.client.fallback;

import org.shay.education.dto.PagedDTO;
import org.shay.education.user.client.UserClient;
import org.shay.education.user.dto.UserDTO;
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
    public PagedDTO<UserDTO> search(int page, int size) {
        logger.info("userClient search fallback");
        return new PagedDTO<>(0L, new ArrayList<>());
    }
}
