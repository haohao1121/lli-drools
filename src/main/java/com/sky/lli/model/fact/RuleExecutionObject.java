package com.sky.lli.model.fact;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：封装规则执行传参对象
 * CLASSPATH: com.sky.lli.model.fact.RuleExecutionObject
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/25
 */
@Data
public class RuleExecutionObject implements Serializable {

    //fact集合
    private List<Object> factObjectList = new ArrayList<>();
    //全局对象集合
    private Map<String, Object> globalMap = new HashMap<>();
    //是否全部执行（默认全部）
    private boolean executeAll = true;
    //根据名称过滤要执行的规则
    private String ruleName;

    /**
     * Date 2017/7/25
     * Author lihao [lihao@sinosoft.com]
     * <p>
     * 方法说明: 添加fact对象
     *
     * @param factObject fact对象
     */
    public void addFactObject(Object factObject) {
        this.factObjectList.add(factObject);
    }

    /**
     * Date 2017/7/25
     * Author lihao [lihao@sinosoft.com]
     * <p>
     * 方法说明: 设置Global参数
     *
     * @param key   key
     * @param value 值
     */
    public void setGlobal(String key, Object value) {
        this.globalMap.put(key, value);
    }
}
