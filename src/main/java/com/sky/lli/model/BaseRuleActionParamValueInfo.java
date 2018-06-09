package com.sky.lli.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.model.BaseRuleActionParamValueInfo
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRuleActionParamValueInfo extends BaseModel {
    private Long actionParamValueId;//主键
    private Long ruleActionRelId;//动作规则关系主键
    private Long actionParamId;//动作参数
    private String paramValue;//参数值
}
