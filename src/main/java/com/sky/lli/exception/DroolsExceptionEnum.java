package com.sky.lli.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 描述：枚举异常
 * CLASSPATH: com.sky.lli.exception.DroolsExceptionEnum.java
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/11/20
 */
public enum DroolsExceptionEnum implements IExceptionEnum {

    /*
     * 异常取值范围划分:
     * <p>
     * 系统保留异常: 00000 -- 10000
     * Redis异常:   10001 -- 11000
     * Mongo异常:   11001 -- 12000
     * 基础异常:    12001 -- 13000
     * 规则引擎相关异常:   14001 -- 15000
     */

    /**
     * ===========================================================
     * *******************以下为业务相关异常信息*********************
     * ===========================================================
     */

    // region ============================基础异常============================
    DROOLS_EXECUTE_FAIL_ERROR("LLI-14001", "规则引擎执行出错"),
    DROOLS_BUILDER_ACTION_FAIL_ERROR("LLI-14002", "构造规则动作对象时出错,请检查"),
    DROOLS_INIT_RULE_FAIL_ERROR("LLI-14003", "Drools初始化失败,请检查Drools语句"),
    DROOLS_UTIL_INIT_FAIL_ERROR("LLI-14004", "Drools初始化失败"),
    //endregion

    // region 自身Get方法和构造函数
    ;
    @Getter
    private String code;
    @Getter
    @Setter
    private String message;

    DroolsExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
    //endregion


}
