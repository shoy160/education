package org.shay.education.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import org.shay.education.enums.UserRole;
import org.shay.education.user.dto.UserDTO;
import org.shay.education.user.enums.UserStatus;

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

    /**
     * 昵称
     */
    @TableField(value = "NickName")
    private String nick;

    /**
     * 姓名
     */
    @TableField(value = "TrueName")
    private String name;

    /**
     * 头像
     */
    @TableField(value = "HeadPhoto")
    private String avatar;

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

    public UserDTO toDto() {
        UserDTO dto = new UserDTO();
        dto.setId(getId());
        dto.setNick(getNick());
        dto.setName(getName());
        dto.setMobile(getMobile());
        dto.setEmail(getEmail());
        dto.setCode(getCode());
        dto.setSubjectId(getSubjectId());
        dto.setRole(UserRole.getEnum(getRole()));
        dto.setStatus(UserStatus.getEnum(getStatus()));
        return dto;
    }
}
