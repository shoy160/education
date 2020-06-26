package org.shay.education.system;

import org.shay.education.dto.ResultCode;
import org.shay.education.dto.ResultDTO;
import org.shay.education.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * todo
 *
 * @author shay
 * @date 2020/6/25
 */
@ControllerAdvice
public class GlobalExceptionResolver {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    /**
     * 未知异常处理
     *
     * @param ex 异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResultDTO handleException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return ResultDTO.fail(ResultCode.INTERNAL_SERVER_ERROR);
    }

    /**
     * 业务异常处理
     *
     * @param ex 业务异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public ResultDTO handleBusinessException(BusinessException ex) {
        logger.warn(String.format("业务异常：%d,%s", ex.getCode(), ex.getMessage()));
        return ResultDTO.fail(ex.getCode(), ex.getMessage());
    }
}
