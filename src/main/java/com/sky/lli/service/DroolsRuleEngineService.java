package com.sky.lli.service;


import com.sky.lli.model.fact.RuleExecutionObject;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.DroolsRuleEngineService
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/25
 */
public interface DroolsRuleEngineService {

    /**
     * Date 2017/7/25
     * Author lihao [lihao@sinosoft.com]
     * <p>
     * 方法说明: 规则引擎执行方法
     *
     * @param ruleExecutionObject facr对象信息
     * @param scene               场景
     */
    RuleExecutionObject excute(RuleExecutionObject ruleExecutionObject, final String scene);
}
