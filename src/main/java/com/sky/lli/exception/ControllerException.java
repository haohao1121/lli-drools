package com.sky.lli.exception;


/**
 * 描述： 控制层异常
 * CLASSPATH: com.sky.lli.exception.ControllerException.java
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/11/20
 */
public class ControllerException extends EnumException {

    private static final long serialVersionUID = 1L;

    public ControllerException(IExceptionEnum responseEnum, String suffix) {
        super(responseEnum, suffix);
    }

    public ControllerException(IExceptionEnum responseEnum) {
        super(responseEnum);
    }


}
