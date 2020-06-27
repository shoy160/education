package org.shay.education.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

/**
 * 基础时间实体
 *
 * @author shay
 * @date 2020/6/27
 */
@Getter
@Setter
public abstract class BaseTimedDTO extends BaseDTO {
    /**
     * 创建时间
     */
    private OffsetDateTime addedAt;
    /**
     * 创建IP
     */
    private String addedIp;
}
