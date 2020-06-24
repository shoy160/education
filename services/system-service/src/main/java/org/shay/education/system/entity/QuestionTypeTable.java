package org.shay.education.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import org.shay.education.enums.NormalStatus;
import org.shay.education.system.dto.QuestionTypeDTO;

/**
 * 题型表
 *
 * @author shay
 */
@Getter
@Setter
@TableName(value = "TS_QuestionType")
public class QuestionTypeTable extends Model<QuestionTypeTable> {

    @TableId(value = "QTypeID")
    private String id;
    /**
     * 题型名称
     */
    @TableField(value = "QTypeName")
    private String name;

    /**
     * 题型备注
     */
    @TableField(value = "QTypeRemark")
    private String remark;

    /**
     * 题型样式
     */
    @TableField(value = "QTypeStyle")
    private Integer style;
    /**
     * 是否有小问
     */
    @TableField(value = "HasSmallQuestion")
    private Boolean smallQuestion;
    /**
     * 是否有多个答案
     */
    @TableField(value = "HasMultiAnswer")
    private Boolean multi;
    /**
     * 状态
     */
    @TableField(value = "Status")
    private Integer status;

    public QuestionTypeDTO toDTO() {
        QuestionTypeDTO dto = new QuestionTypeDTO();
        dto.setId(getId());
        dto.setName(getName());
        dto.setRemark(getRemark());
        dto.setStyle(getStyle());
        dto.setSmallQuestion(getSmallQuestion());
        dto.setMulti(getMulti());
        dto.setStatus(NormalStatus.getEnum(getStatus()));
        return dto;
    }
}
