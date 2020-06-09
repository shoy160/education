package org.shay.education.user.dto;

import lombok.Getter;
import lombok.Setter;
import org.shay.education.dto.BaseDto;

/**
 * @author shay
 * @date 2020/6/8
 */
@Getter
@Setter
public class UserDto extends BaseDto {
    private long id;
    private String nick;
    private String name;
    private String mobile;
    private String email;
    private String code;
    private int subjectId;
    private short role;
    private short status;
}
