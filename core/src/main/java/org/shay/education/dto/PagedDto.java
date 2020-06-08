package org.shay.education.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 分页实体
 *
 * @author shay
 * @date 2020/6/8
 */
@Getter
@Setter
@AllArgsConstructor
public class PagedDto<T extends BaseDto> extends BaseDto {
    private int total;
    private List<T> list;

    public static <T extends BaseDto> PagedDto<T> paged(List<T> list) {
        return new PagedDto<>(list.size(), list);
    }
}
