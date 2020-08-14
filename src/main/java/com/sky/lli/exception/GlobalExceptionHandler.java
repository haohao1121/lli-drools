package com.sky.lli.exception;

import com.sky.lli.util.restful.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLSyntaxErrorException;

import static com.sky.lli.util.restful.ResultResponseUtils.error;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.exception.GlobalExceptionHandler
 * VERSION:   1.0
 * Created by lihao
 * DATE: 2017/11/21
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 匹配 error 并处理
     */
    private static final String ERROR_PATH = "/error";

    /**
     * 本方法处理 Exception 抛出异常的情况
     *
     * @param e 传递的最顶级的异常
     * @return 返回响应
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult<Object> handle(Exception e) {
        if (e instanceof EnumException) {
            EnumException enumException = (EnumException) e;
            IExceptionEnum responseEnum = enumException.getResponseEnum();
            log.error("异常提示如下，CODE:{}，额外 Message:{}", responseEnum.getCode(), responseEnum.getMessage());
            return error(responseEnum, responseEnum.getMessage() + enumException.getSuffix());
        }

        log.error("异常如下行所示：", e);
        if (e instanceof HttpRequestMethodNotSupportedException) {
            return error(ExceptionEnum.SYS_METHOD_NOT_ALLOWED);
        }
        if (e instanceof HttpMessageNotReadableException) {
            return error(ExceptionEnum.SYS_JSON_DATA_ERROR);
        }
        if (e instanceof HttpMediaTypeNotSupportedException) {
            return error(ExceptionEnum.SYS_UNSUPPORTED_MEDIA_TYPE);
        }
        if (e instanceof SQLSyntaxErrorException) {
            return error(ExceptionEnum.SYS_DATABASE_FIELD_NOT_EXIST);
        }
        if (e instanceof DataAccessException) {
            return error(ExceptionEnum.SYS_DATABASE_FAILURE);
        }

        return error(ExceptionEnum.SYS_FAILURE_EXCEPTION);
    }
}
