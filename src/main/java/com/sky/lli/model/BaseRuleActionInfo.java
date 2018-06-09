package com.sky.lli.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.model.BaseRuleActionInfo
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRuleActionInfo extends BaseModel {

    private Long actionId;//主键
    private Integer actionType;//动作类型
    private String actionName;//动作名称
    private String actionDesc;//动作描述
    private String actionClass;//动作实现类

    /**
     * 获取实体标识(例如：com.sky.lli.model.TestRule  最后得到 testRule)
     */
    public String getActionClazzIdentify() {
        int index = actionClass.lastIndexOf('.');
        return actionClass.substring(index + 1).substring(0, 1).toLowerCase() +
                actionClass.substring(index + 1).substring(1);
    }
}
