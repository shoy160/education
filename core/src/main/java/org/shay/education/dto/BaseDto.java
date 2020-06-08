package org.shay.education.dto;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @author shay
 * @date 2020/6/8
 */
public abstract class BaseDto implements Serializable {
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
