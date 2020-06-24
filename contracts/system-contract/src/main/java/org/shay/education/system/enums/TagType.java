package org.shay.education.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.shay.education.enums.UserRole;

/**
 * @author shay
 * @date 2020/6/8
 */
@Getter
@AllArgsConstructor
public enum TagType {
    /**
     * 系统标签
     */
    System(0, "系统标签"), Question(1, "题库标签"), Paper(2, "试卷标签");

    private final Integer value;
    private final String name;

    public static TagType getEnum(int value) {
        for (TagType bt : values()) {
            if (bt.getValue() == value) {
                return bt;
            }
        }
        return null;
    }
}
