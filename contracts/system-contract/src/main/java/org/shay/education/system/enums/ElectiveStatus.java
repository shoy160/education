package org.shay.education.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 选修课状态
 *
 * @author shay
 * @date 2020/6/24
 */

@Getter
@AllArgsConstructor
public enum ElectiveStatus {
    /**
     * 未开始
     */
    Normal(0, "未开始"),
    /**
     * 进行中
     */
    Started(1, "进行中"),
    /**
     * 已结束
     */
    Finished(2, "已结束"),
    /**
     * 已删除
     */
    Delete(4, "已删除");
    private final Integer value;
    private final String name;

    public static ElectiveStatus getEnum(int value) {
        for (ElectiveStatus bt : values()) {
            if (bt.getValue() == value) {
                return bt;
            }
        }
        return null;
    }
}
