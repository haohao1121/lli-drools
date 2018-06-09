package com.sky.lli.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.model.BaseRuleActionRuleRelInfo
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRuleActionRuleRelInfo extends BaseModel {
    private Long ruleActionRelId;//主键
    private Long actionId;//动作
    private Long ruleId;//规则
}
