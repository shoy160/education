package org.shay.education.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户角色
 *
 * @author shay
 * @date 2020/6/24
 */
@Getter
@AllArgsConstructor
public enum UserRole {
    /**
     * 游民
     */
    Vagrant(0, "游民"),
    /**
     * 家长
     */
    Parents(1, "家长"),
    /**
     * 学生
     */
    Student(2, "学生"),
    /**
     * 教师
     */
    Teacher(4, "教师"),
    /**
     * 管理员
     */
    System(128, "管理员");
    private final Integer value;
    private final String name;

    public static UserRole getEnum(int value) {
        for (UserRole bt : values()) {
            if (bt.getValue() == value) {
                return bt;
            }
        }
        return null;
    }
}
