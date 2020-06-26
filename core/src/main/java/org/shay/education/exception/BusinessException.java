package org.shay.education.exception;

import lombok.Getter;
import lombok.Setter;
import org.shay.education.dto.ResultCode;

/**
 * 业务异常
 *
 * @author shay
 * @date 2020/6/25
 */
@Getter
@Setter
public class BusinessException extends RuntimeException {
    private Integer code;
    private String message;

    public BusinessException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public BusinessException(String message) {
        super(message);
        this.code = ResultCode.INTERNAL_SERVER_ERROR.getCode();
        this.message = message;
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
