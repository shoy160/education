package org.shay.education.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 认证等级
 *
 * @author shay
 * @date 2020/6/27
 */
@Getter
@AllArgsConstructor
public enum CertificationLevel {
    /**
     * 未认证
     */
    None(0, "未认证"),
    /**
     * 官方认证
     */
    Official(1, "官方认证");
    private final Integer value;
    private final String name;

    public static CertificationLevel getEnum(int value) {
        for (CertificationLevel bt : values()) {
            if (bt.getValue() == value) {
                return bt;
            }
        }
        return null;
    }
}
