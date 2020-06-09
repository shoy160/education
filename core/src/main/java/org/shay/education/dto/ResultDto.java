package org.shay.education.dto;

import lombok.Getter;
import lombok.Setter;

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

    private ResultDto(T data) {
        this.success = true;
        this.code = 200;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    private ResultDto(String message, int code) {
        this.success = code == 200;
        this.code = code;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    private static <T> ResultDto<T> result(ResultCode resultCode) {
        return new ResultDto<>(resultCode.getMessage(), resultCode.getCode());
    }

    public static <T> ResultDto<T> success(T data) {
        return new ResultDto<>(data);
    }

    public static <T> ResultDto<T> success() {
        return result(ResultCode.SUCCESS);
    }

    public static <T> ResultDto<T> fail(int code, String message) {
        return new ResultDto<>(message, code);
    }

    public static <T> ResultDto<T> fail(ResultCode resultCode) {
        return result(resultCode);
    }
}
