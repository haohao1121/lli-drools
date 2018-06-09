package com.sky.lli.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.model.BaseRulePropertyInfo
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRulePropertyInfo extends BaseModel{
    private Long rulePropertyId;//主键
    private String rulePropertyIdentify;//标识
    private String rulePropertyName;//名称
    private String rulePropertyDesc;//描述
    private String defaultValue;//默认值
}
