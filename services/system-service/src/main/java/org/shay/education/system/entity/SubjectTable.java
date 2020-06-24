package org.shay.education.system.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import org.shay.education.enums.NormalStatus;
import org.shay.education.system.dto.SubjectDTO;

/**
 * 科目表
 *
 * @author shay
 */
@Getter
@Setter
@TableName("TS_Subject")
public class SubjectTable extends Model<SubjectTable> {

    @TableId(value = "SubjectID")
    private String id;
    /**
     * 科目名称
     */
    @TableField(value = "SubjectName")
    private String name;
    /**
     * 科目图标
     */
    @TableField(value = "Icon")
    private String icon;
    /**
     * 是否需要加载公式
     */
    @TableField(value = "IsLoadFormula")
    private Boolean loadFormula;
    /**
     * 题型列表
     */
    @TableField(value = "QTypeIDs")
    private String questionTypes;
    /**
     * 科目状态
     */
    @TableField(value = "Status")
    private Short status;

    /**
     * 转换实体
     *
     * @return
     */
    public SubjectDTO toDTO() {
        SubjectDTO dto = new SubjectDTO();
        dto.setId(getId());
        dto.setName(getName());
        dto.setIcon(getIcon());
        dto.setLoadFormula(getLoadFormula());
        String typesJson = getQuestionTypes();
        if (null != typesJson) {
            JSONArray array = JSON.parseArray(typesJson);
            Integer[] types = new Integer[array.size()];
            types = array.toArray(types);
            dto.setQuestionTypes(types);
        }
        dto.setStatus(NormalStatus.getEnum(getStatus()));
        return dto;
    }
}
