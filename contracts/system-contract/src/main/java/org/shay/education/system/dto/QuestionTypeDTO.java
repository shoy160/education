package org.shay.education.system.dto;

import lombok.Getter;
import lombok.Setter;
import org.shay.education.dto.BaseDTO;
import org.shay.education.enums.NormalStatus;

/**
 * 题型实体
 *
 * @author shay
 * @date 2020/6/24
 */
@Getter
@Setter
public class QuestionTypeDTO extends BaseDTO {
    private String id;
    /**
     * 题型名称
     */
    private String name;

    /**
     * 题型备注
     */
    private String remark;
    /**
     * 题型样式
     */
    private Integer style;
    /**
     * 是否有小问
     */
    private Boolean smallQuestion;
    /**
     * 是否有多个答案
     */
    private Boolean multi;
    /**
     * 状态
     */
    private NormalStatus status;
}
