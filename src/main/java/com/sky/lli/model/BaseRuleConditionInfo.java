package com.sky.lli.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.model.BaseRuleConditionInfo
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRuleConditionInfo extends BaseModel {
    private Long conditionId;//主键
    private Long ruleId;//规则id
    private String conditionName;//条件名称
    private String conditionExpression;//条件表达式
    private String conditionDesc;//条件描述
}
