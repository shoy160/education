package org.shay.education.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态枚举
 *
 * @author shay
 * @date 2020/6/24
 */
@Getter
@AllArgsConstructor
public enum NormalStatus {
    /**
     * 正常
     */
    Normal(0, "正常"),
    /**
     * 删除
     */
    Delete(4, "删除");
    private final Integer value;
    private final String name;

    public static NormalStatus getEnum(int value) {
        for (NormalStatus bt : values()) {
            if (bt.getValue() == value) {
                return bt;
            }
        }
        return null;
    }
}
