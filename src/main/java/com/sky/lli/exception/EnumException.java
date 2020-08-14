package com.sky.lli.exception;

import lombok.Getter;

import static java.util.Objects.isNull;

/**
 * 描述： 集成运行时异常的自定义异常
 * CLASSPATH: com.sky.lli.exception.EnumException.java
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/11/20
 */
class EnumException extends RuntimeException {

    /**
     * 错误的枚举返回
     */
    @Getter
    private IExceptionEnum responseEnum;

    /**
     * 补充错误信息
     */
    private String suffix;

    EnumException(IExceptionEnum responseEnum) {
        this.responseEnum = responseEnum;
    }

    EnumException(IExceptionEnum responseEnum, String suffix) {
        super();
        this.responseEnum = responseEnum;
        this.suffix = suffix;
    }

    String getSuffix() {
        return isNull(this.suffix) ? "" : this.suffix;
    }

}
