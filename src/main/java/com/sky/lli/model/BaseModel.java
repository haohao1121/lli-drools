package com.sky.lli.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.model.BaseModel
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/20
 */
@Data
public class BaseModel implements Serializable {
    //创建人
    private Long creUserId;
    //创建时间
    private Date creTime;
    //是否有效
    private Integer isEffect;
    //备注
    private String remark;
}
