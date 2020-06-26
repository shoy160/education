package org.shay.education.system.dto;

import lombok.Getter;
import lombok.Setter;
import org.shay.education.dto.BaseDTO;
import org.shay.education.enums.UserRole;
import org.shay.education.system.enums.ApplicationType;

/**
 * 创建应用实体
 *
 * @author shay
 * @date 2020/6/24
 */
@Getter
@Setter
public class ApplicationInputDTO extends BaseDTO {
    /**
     * 应用名
     */
    private String name;
    /**
     * 应用链接
     */
    private String url;
    /**
     * 应用图标
     */
    private String icon;

    /**
     * 是否二级域名
     */
    private Boolean sld;

    /**
     * 应用备注
     */
    private String remark;
    /**
     * 应用权限
     */
    private UserRole[] roles;
    /**
     * 应用类型
     */
    private ApplicationType type;
    /**
     * 应用排序
     */
    private Integer sort;
}
