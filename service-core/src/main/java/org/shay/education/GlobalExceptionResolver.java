package org.shay.education;

import lombok.extern.slf4j.Slf4j;
import org.shay.education.dto.ResultCode;
import org.shay.education.dto.ResultDTO;
import org.shay.education.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author shay
 * @date 2020/6/25
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionResolver {

    /**
     * 未知异常处理
     *
     * @param ex 异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResultDTO handleException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return ResultDTO.fail(ResultCode.INTERNAL_SERVER_ERROR);
    }

    /**
     * 处理参数校验异常
     *
     * @param ex ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultDTO handleArgException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        if (result.hasErrors()) {
            ObjectError error = result.getFieldError();
            return ResultDTO.fail(ResultCode.PARAM_VALID_ERROR, error.getDefaultMessage());
        }
        return ResultDTO.fail(ResultCode.PARAM_VALID_ERROR);
    }

    /**
     * 业务异常处理
     *
     * @param ex 业务异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler({BusinessException.class,})
    public ResultDTO handleBusinessException(BusinessException ex) {
        log.warn(String.format("业务异常：%d,%s", ex.getCode(), ex.getMessage()));
        return ResultDTO.fail(ex.getCode(), ex.getMessage());
    }
}
