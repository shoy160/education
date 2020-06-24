package org.shay.education.system.dto;

import lombok.Getter;
import lombok.Setter;
import org.shay.education.dto.BaseDTO;
import org.shay.education.enums.NormalStatus;

/**
 * 科目实体
 *
 * @author shay
 * @date 2020/6/24
 */
@Getter
@Setter
public class SubjectDTO extends BaseDTO {

    private String id;
    /**
     * 科目名称
     */
    private String name;
    /**
     * 科目图标
     */
    private String icon;
    /**
     * 是否需要加载公式
     */
    private Boolean loadFormula;
    /**
     * 题型列表
     */
    private Integer[] questionTypes;
    /**
     * 科目状态
     */
    private NormalStatus status;
}
