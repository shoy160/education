package org.shay.education.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 家庭关系
 *
 * @author shay
 * @date 2020/6/27
 */
@Getter
@AllArgsConstructor
public enum FamilyRelationType {

    /**
     * 爸爸
     */
    Father(1, "爸爸"),
    /**
     * 妈妈
     */
    Mother(2, "妈妈"),
    /**
     * 爷爷
     */
    GrandFather(3, "爷爷"),
    /**
     * 奶奶
     */
    GrandMother(4, "奶奶"),
    /**
     * 其他
     */
    Other(10, "其他");
    private final Integer value;
    private final String name;

    public static FamilyRelationType getEnum(int value) {
        for (FamilyRelationType bt : values()) {
            if (bt.getValue() == value) {
                return bt;
            }
        }
        return null;
    }
}
