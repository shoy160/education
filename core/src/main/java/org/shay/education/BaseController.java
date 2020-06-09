package org.shay.education;

import org.shay.education.dto.ResultCode;
import org.shay.education.dto.ResultDto;

/**
 * 基础控制器
 *
 * @author shay
 * @date 2020/6/9
 */
public abstract class BaseController {

    protected <T> ResultDto<T> success() {
        return ResultDto.success();
    }

    protected <T> ResultDto<T> success(T data) {
        return ResultDto.success(data);
    }

    protected <T> ResultDto<T> fail(ResultCode resultCode) {
        return ResultDto.fail(resultCode);
    }

    private <T> ResultDto<T> fail(String message) {
        return ResultDto.fail(ResultCode.INTERNAL_SERVER_ERROR.getCode(), message);
    }

    private <T> ResultDto<T> fail(String message, int code) {
        return ResultDto.fail(code, message);
    }
}
