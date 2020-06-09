package org.shay.education.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import org.shay.education.user.dto.UserDto;

/**
 * @author shay
 * @date 2020/6/9
 */
@Getter
@Setter
@TableName("TU_User")
public class UserTable extends Model<UserTable> {
    @TableId(value = "UserID", type = IdType.AUTO)
    private long id;
    @TableField(value = "NickName")
    private String nick;
    @TableField(value = "TrueName")
    private String name;
    @TableField(value = "Mobile")
    private String mobile;
    @TableField(value = "Email")
    private String email;
    @TableField(value = "SubjectID")
    private int subjectId;
    @TableField(value = "UserCode")
    private String code;
    @TableField(value = "Role")
    private short role;
    @TableField(value = "Status")
    private short status;

    public UserDto toDto() {
        UserDto dto = new UserDto();
        dto.setId(getId());
        dto.setNick(getNick());
        dto.setName(getName());
        dto.setMobile(getMobile());
        dto.setEmail(getEmail());
        dto.setCode(getCode());
        dto.setSubjectId(getSubjectId());
        dto.setRole(getRole());
        dto.setStatus(getStatus());
        return dto;
    }
}
