package org.shay.education.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import org.shay.education.enums.NormalStatus;
import org.shay.education.system.dto.TagDTO;
import org.shay.education.system.enums.TagType;

/**
 * @author shay
 * @date 2020/6/8
 */
@Getter
@Setter
@TableName("TS_Tag")
public class TagTable extends Model<TagTable> {
    @TableId(value = "TagID", type = IdType.AUTO)
    private int id;
    @TableField(value = "TagName")
    private String name;
    @TableField(value = "TagType")
    private int type;
    @TableField(value = "FullPinYin")
    private String fullPinyin;
    @TableField(value = "SimplePinYin")
    private String simplePinyin;
    @TableField(value = "UsedCount")
    private int count;
    @TableField(value = "Status")
    private int status;

    public TagDTO toDTO() {
        TagDTO dto = new TagDTO();
        dto.setId(getId());
        dto.setName(getName());
        dto.setFullPinyin(getFullPinyin());
        dto.setSimplePinyin(getSimplePinyin());
        dto.setType(TagType.values()[getType()]);
        dto.setCount(getCount());
        dto.setStatus(NormalStatus.getEnum(getStatus()));
        return dto;
    }
}
