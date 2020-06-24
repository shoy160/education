package org.shay.education.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import org.shay.education.enums.NormalStatus;
import org.shay.education.enums.UserRole;
import org.shay.education.system.dto.ApplicationDTO;
import org.shay.education.system.enums.ApplicationType;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用表
 *
 * @author shay
 */
@Getter
@Setter
@TableName(value = "TS_Application")
public class ApplicationTable extends Model<ApplicationTable> {

    @TableId(value = "AppID", type = IdType.AUTO)
    private Integer id;
    /**
     * 应用名
     */
    @TableField(value = "AppName")
    private String name;
    /**
     * 应用链接
     */
    @TableField(value = "AppURL")
    private String url;
    /**
     * 应用图标
     */
    @TableField(value = "AppIcon")
    private String icon;

    /**
     * 是否二级域名
     */
    @TableField(value = "IsSLD")
    private Boolean sld;

    /**
     * 应用备注
     */
    @TableField(value = "AppRemark")
    private String remark;
    /**
     * 应用权限
     */
    @TableField(value = "AppRoles")
    private Integer roles;
    /**
     * 应用状态
     */
    @TableField(value = "Status")
    private Integer status;
    /**
     * 应用类型
     */
    @TableField(value = "AppType")
    private Integer type;
    /**
     * 应用排序
     */
    @TableField(value = "Sort")
    private Integer sort;

    public ApplicationDTO toDTO() {
        ApplicationDTO dto = new ApplicationDTO();
        dto.setId(getId());
        dto.setName(getName());
        dto.setUrl(getUrl());
        dto.setIcon(getIcon());
        dto.setSld(getSld());
        dto.setRemark(getRemark());
        List<UserRole> roles = new ArrayList<>();
        Integer roleValue = getRoles();
        for (UserRole role : UserRole.values()) {
            if ((role.getValue() & roleValue) > 0) {
                roles.add(role);
            }
        }
        dto.setRoles(roles.toArray(new UserRole[0]));
        dto.setStatus(NormalStatus.getEnum(getStatus()));
        dto.setType(ApplicationType.getEnum(getType()));
        dto.setSort(getSort());
        return dto;
    }
}
