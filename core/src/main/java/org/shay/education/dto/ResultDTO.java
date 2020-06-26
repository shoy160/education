package org.shay.education.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shay
 * @date 2020/6/8
 */
@Getter
@Setter
public class ResultDTO<T> extends BaseDTO {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 成功标示
     */
    private Boolean success;

    private String message;
    /**
     * 数据
     */
    private T data;
    /**
     * 时间戳
     */
    private Long timestamp;

    private ResultDTO(T data) {
        this.success = true;
        this.code = 200;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    private ResultDTO(String message, int code) {
        this.success = code == 200;
        this.code = code;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    private static <T> ResultDTO<T> result(ResultCode resultCode) {
        return new ResultDTO<>(resultCode.getMessage(), resultCode.getCode());
    }

    public static <T> ResultDTO<T> success(T data) {
        return new ResultDTO<>(data);
    }

    public static <T> ResultDTO<T> success() {
        return result(ResultCode.SUCCESS);
    }

    public static <T> ResultDTO<T> fail(int code, String message) {
        return new ResultDTO<>(message, code);
    }

    public static <T> ResultDTO<T> fail(ResultCode resultCode) {
        return result(resultCode);
    }
}
