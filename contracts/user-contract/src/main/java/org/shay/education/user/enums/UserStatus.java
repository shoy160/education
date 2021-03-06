package org.shay.education.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.shay.education.enums.UserRole;

/**
 * 用户状态
 *
 * @author shay
 */

@Getter
@AllArgsConstructor
public enum UserStatus {
    /**
     * 正常
     */
    Normal(0, "正常"),
    /**
     * 未绑定
     */
    UnBind(2, "未绑定"),
    /**
     * 删除
     */
    Delete(4, "删除");
    private final Integer value;
    private final String name;

    public static UserStatus getEnum(int value) {
        for (UserStatus bt : values()) {
            if (bt.getValue() == value) {
                return bt;
            }
        }
        return null;
    }
}
