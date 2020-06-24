package org.shay.education.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import org.shay.education.system.dto.AreaDTO;

/**
 * 区域表
 *
 * @author shay
 */
@Getter
@Setter
@TableName(value = "TS_Area")
public class AreaTable extends Model<AreaTable> {
    @TableId(value = "Code")
    private Integer id;

    /**
     * 区域名称
     */
    @TableField(value = "Name")
    private String name;
    /**
     * 父级编码
     */
    @TableField(value = "ParentCode")
    private Integer parentCode;
    /**
     * 全拼
     */
    @TableField(value = "FullPinYin")
    private String fullPinyin;
    /**
     * 简拼
     */
    @TableField(value = "SimplePinYin")
    private String simplePinyin;
    /**
     * 排序
     */
    @TableField(value = "Sort")
    private Integer sort;

    public AreaDTO toDTO() {
        AreaDTO dto = new AreaDTO();
        dto.setId(getId());
        dto.setName(getName());
        dto.setParentCode(getParentCode());
        dto.setFullPinyin(getFullPinyin());
        dto.setSimplePinyin(getSimplePinyin());
        dto.setSort(getSort());
        return dto;
    }
}
