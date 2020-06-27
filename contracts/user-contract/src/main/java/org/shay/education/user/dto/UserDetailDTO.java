package org.shay.education.user.dto;

import lombok.Getter;
import lombok.Setter;
import org.shay.education.user.enums.CertificationLevel;
import org.shay.education.user.enums.ValidationType;

import java.time.OffsetDateTime;

/**
 * 用户详情实体
 *
 * @author shay
 * @date 2020/6/27
 */
@Getter
@Setter
public class UserDetailDTO extends UserDTO {
    private String studentNum;
    private String lastLoginIp;
    private OffsetDateTime lastLoginAt;
    private CertificationLevel certificationLevel;
    private String agentId;
    private Integer visitCount;
    private Integer goodCount;
    private String banner;
    private String signature;
    private ValidationType[] validationType;
}
