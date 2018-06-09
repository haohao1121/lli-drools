package com.sky.lli.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.model.BaseRuleInfo
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRuleInfo extends BaseModel {
    private Long ruleId;//主键
    private Long sceneId;//场景
    private String ruleName;//名称
    private String ruleDesc;//描述
    private Integer ruleEnabled;//是否启用
}
