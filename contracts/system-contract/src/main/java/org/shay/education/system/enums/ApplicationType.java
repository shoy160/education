package org.shay.education.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 应用类型
 *
 * @author shay
 * @date 2020/6/24
 */

@Getter
@AllArgsConstructor
public enum ApplicationType {
    /**
     * 普通应用
     */
    Normal(0, "普通应用"),
    /**
     * 附加应用
     */
    Additional(4, "附加应用"),
    /**
     * 收费应用
     */
    Paid(8, "收费应用");
    private final Integer value;
    private final String name;

    public static ApplicationType getEnum(int value) {
        for (ApplicationType bt : values()) {
            if (bt.getValue() == value) {
                return bt;
            }
        }
        return null;
    }
}
