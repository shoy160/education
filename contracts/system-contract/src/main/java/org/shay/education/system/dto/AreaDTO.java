package org.shay.education.system.dto;

import lombok.Getter;
import lombok.Setter;
import org.shay.education.dto.BaseDTO;

/**
 * 区域实体
 *
 * @author shay
 * @date 2020/6/24
 */
@Getter
@Setter
public class AreaDTO extends BaseDTO {
    private Integer id;
    private String name;
    /**
     * 父级编码
     */
    private Integer parentCode;
    /**
     * 全拼
     */
    private String fullPinyin;
    /**
     * 简拼
     */
    private String simplePinyin;
    /**
     * 排序
     */
    private Integer sort;
}
