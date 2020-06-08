package org.shay.education.system.enums;

import lombok.AllArgsConstructor;

/**
 * @author shay
 * @date 2020/6/8
 */
@AllArgsConstructor
public enum TagType {
    /**
     * 系统标签
     */
    System(0, "系统标签"), Question(1, "题库标签"), Paper(2, "试卷标签");

    private int value;
    private String name;
}
