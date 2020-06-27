package org.shay.education.user.dto;

import lombok.Getter;
import lombok.Setter;
import org.shay.education.dto.BaseTimedDTO;
import org.shay.education.enums.Gender;
import org.shay.education.enums.UserRole;
import org.shay.education.user.enums.UserStatus;

/**
 * @author shay
 * @date 2020/6/8
 */
@Getter
@Setter
public class UserDTO extends BaseTimedDTO {
    private Long id;
    private String nick;
    private String name;
    private String avatar;
    private String mobile;
    private String email;
    private String code;
    private Integer subjectId;
    private Integer area;
    private Gender gender;
    private UserRole role;
    private UserStatus status;

    public UserDTO get() {
        return this;
    }
}
