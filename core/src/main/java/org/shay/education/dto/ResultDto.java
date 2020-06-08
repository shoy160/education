package org.shay.education.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;

/**
 * @author shay
 * @date 2020/6/8
 */
@Getter
@Setter
public class ResultDto<T> extends BaseDto {
    /**
     * 成功标示
     */
    private boolean success;
    /**
     * 状态码
     */
    private int code;

    private String message;
    /**
     * 数据
     */
    private T data;
    /**
     * 时间戳
     */
    private long timestamp;

    public ResultDto(T data) {
        this.success = true;
        this.code = 200;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public ResultDto(String message, int code) {
        this.success = code == 200;
        this.code = code;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }
}
