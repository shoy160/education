package org.shay.education.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 性别
 *
 * @author shay
 * @date 2020/6/27
 */
@Getter
@AllArgsConstructor
public enum Gender {
    /**
     * 保密
     */
    Secret(0, "保密"),
    /**
     * 男性
     */
    Male(1, "男性"),
    /**
     * 女性
     */
    Female(2, "女性");
    private final Integer value;
    private final String name;

    public static Gender getEnum(int value) {
        for (Gender bt : values()) {
            if (bt.getValue() == value) {
                return bt;
            }
        }
        return null;
    }
}
