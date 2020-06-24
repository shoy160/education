package org.shay.education.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 名称实体
 *
 * @author shay
 * @date 2020/6/24
 */
@Getter
@Setter
public class NamedDTO<T, TV> extends BaseDTO {
    private T id;
    private TV name;
}
