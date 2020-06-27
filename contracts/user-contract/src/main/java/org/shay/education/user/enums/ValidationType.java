package org.shay.education.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 认证类型
 *
 * @author shay
 * @date 2020/6/27
 */
@Getter
@AllArgsConstructor
public enum ValidationType {

    /**
     * 未认证
     */
    None(0, "未认证"),
    /**
     * 邮箱认证
     */
    Email(1, "邮箱认证"),
    /**
     * 手机认证
     */
    Mobile(2, "手机认证"),
    /**
     * 第三方认证
     */
    Third(4, "第三方认证");

    private final Integer value;
    private final String name;

    public static ValidationType getEnum(int value) {
        for (ValidationType bt : values()) {
            if (bt.getValue() == value) {
                return bt;
            }
        }
        return null;
    }
}
