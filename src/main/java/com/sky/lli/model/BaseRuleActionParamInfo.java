package com.sky.lli.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.model.BaseRuleActionParamInfo
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRuleActionParamInfo extends BaseModel {
    private Long actionParamId;//主键
    private Long actionId;//动作id
    private String actionParamName;//参数名称
    private String actionParamDesc;//参数描述
    private String paramIdentify;//标识
}
