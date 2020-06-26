package org.shay.education.web;

import org.shay.education.dto.ResultCode;
import org.shay.education.dto.ResultDTO;

/**
 * 基础控制器
 *
 * @author shay
 * @date 2020/6/9
 */
public abstract class BaseController {

    protected <T> ResultDTO<T> success() {
        return ResultDTO.success();
    }

    protected <T> ResultDTO<T> success(T data) {
        return ResultDTO.success(data);
    }

    protected <T> ResultDTO<T> fail(ResultCode resultCode) {
        return ResultDTO.fail(resultCode);
    }

    private <T> ResultDTO<T> fail(String message) {
        return ResultDTO.fail(ResultCode.INTERNAL_SERVER_ERROR.getCode(), message);
    }

    private <T> ResultDTO<T> fail(String message, int code) {
        return ResultDTO.fail(code, message);
    }
}
