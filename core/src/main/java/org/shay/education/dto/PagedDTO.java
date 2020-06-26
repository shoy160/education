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
public class PagedDTO<T extends BaseDTO> extends BaseDTO {
    private Integer total;
    private List<T> list;

    public static <T extends BaseDTO> PagedDTO<T> paged(List<T> list) {
        return new PagedDTO<>(list.size(), list);
    }
}
