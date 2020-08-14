package com.sky.lli.util.restful;

import com.sky.lli.exception.ExceptionEnum;
import com.sky.lli.exception.IExceptionEnum;

/**
 * 创建时间：2017/4/30  14:34
 * 类名：ResultResponseUtils
 * 描述：前端返回vo的统一工具处理
 */
public class ResultResponseUtils {

    private ResultResponseUtils() {
    }

    private static ResponseResult<Object> success(IExceptionEnum code, Object data) {
        return new ResponseResult<>(code.getCode(), code.getMessage(), data);
    }

    private static ResponseResult<Object> error(IExceptionEnum code, String errorMessage, Object data) {
        return new ResponseResult<>(code.getCode(), code.getMessage(), data);
    }

    /**
     * 仅仅为操作成功，无须任何自定义信息时，默认返回 {@link ExceptionEnum#SYS_INVOKING_SUCCESS}
     *
     * @return ResponseResult 返回状态为 {@link ExceptionEnum#SYS_INVOKING_SUCCESS}
     */
    public static ResponseResult<Object> success() {
        return success(ExceptionEnum.SYS_INVOKING_SUCCESS, null);
    }

    /**
     * 仅仅为操作成功，并返回数据，默认返回 {@link ExceptionEnum#SYS_INVOKING_SUCCESS}
     *
     * @param data 需要返回的数据 data
     * @return ResponseResult 返回状态为 {@link ExceptionEnum#SYS_INVOKING_SUCCESS} 数据为传入的 data
     */
    public static ResponseResult<Object> success(Object data) {
        return success(ExceptionEnum.SYS_INVOKING_SUCCESS, data);
    }

    /**
     * 错误的时候传递的给前端的信息
     *
     * @param code {@link ExceptionEnum} 的枚举状态码
     * @return ResponseResult<Object> 传递给前端的信息，返回的消息自动从 {@link ExceptionEnum} 获取，返回对象为 null
     */
    public static ResponseResult<Object> error(IExceptionEnum code) {
        return error(code, code.getMessage(), null);
    }

    /**
     * 错误的时候传递的给前端的信息，并返回数据
     *
     * @param code {@link ExceptionEnum} 的枚举状态码
     * @param data 需要返回的数据 data
     * @return ResponseResult<Object> 传递给前端的信息，返回的消息自动从 {@link ExceptionEnum} 获取，返回对象为 null
     */
    public static ResponseResult<Object> error(IExceptionEnum code, Object data) {
        return error(code, code.getMessage(), data);
    }

    /**
     * 错误的时候传递的给前端的信息
     *
     * @param code         {@link ExceptionEnum} 的枚举状态码
     * @param errorMessage 如果为空则自动获取 {@link ExceptionEnum} 中的信息
     * @return ResponseResult<Object> 传递给前端的信息
     */
    public static ResponseResult<Object> error(IExceptionEnum code, String errorMessage) {
        return error(code, errorMessage, null);
    }
}
