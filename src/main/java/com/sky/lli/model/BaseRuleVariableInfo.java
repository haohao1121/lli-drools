package com.sky.lli.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.model.BaseRuleVariableInfo
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRuleVariableInfo extends BaseModel {
    private Long variableId;//主键
    private String variableName;//变量名称
    private Integer variableType;//变量类型
    private String defaultValue;//默认值
    private Integer valueType;//数值类型
    private String variableValue;//变量值
}
