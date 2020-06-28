package org.shay.education.utils;

import java.util.EnumSet;

/**
 * @author shay
 * @date 2020/6/8
 */
public class CommonUtils {
    public static <T extends Enum<T>> T getEnum(Class<T> clzz, int value) {
        for (T item : EnumSet.allOf(clzz)) {
            if (item.ordinal() == value) {
                return item;
            }
        }
        return null;
    }
}
