package org.shay.education.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 创造者DTO
 *
 * @author shay
 * @date 2020/6/27
 */
@Getter
@Setter
public abstract class BaseCreatorDTO extends BaseDTO {
    /**
     * 创建人ID
     */
    private Long addedBy;
    /**
     * 创建人
     */
    private String addedName;
}
