package com.sky.lli.service.impl;

import com.github.pagehelper.PageInfo;
import com.sky.lli.dao.BaseRuleSceneEntityRelInfoMapper;
import com.sky.lli.exception.ExceptionEnum;
import com.sky.lli.exception.ServiceException;
import com.sky.lli.model.BaseRuleEntityInfo;
import com.sky.lli.model.BaseRuleSceneEntityRelInfo;
import com.sky.lli.model.BaseRuleSceneInfo;
import com.sky.lli.service.RuleSceneEntityRelService;
import com.sky.lli.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleSceneEntityRelServiceImpl
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/24
 */
@Service
public class RuleSceneEntityRelServiceImpl implements RuleSceneEntityRelService {

    @Resource
    private BaseRuleSceneEntityRelInfoMapper baseRuleSceneEntityRelInfoMapper;


    /**
     * Date 2017/7/24
     * Author lihao [lihao@sinosoft.com]
     * <p>
     * 方法说明: 查询场景与实体关系表信息
     *
     * @param baseRuleSceneEntityRelInfo 参数
     * @param page                       分页参数
     */
    @Override
    public List<BaseRuleSceneEntityRelInfo> findBaseRuleSceneEntityRelInfoList(BaseRuleSceneEntityRelInfo baseRuleSceneEntityRelInfo, PageInfo page) {
        return this.baseRuleSceneEntityRelInfoMapper.findBaseRuleSceneEntityRelInfoList(baseRuleSceneEntityRelInfo);
    }

    /**
     * Date 2017/7/26
     * Author lihao [lihao@sinosoft.com]
     * <p>
     * 方法说明: 根据场景信息获取相关的实体信息
     *
     * @param baseRuleSceneInfo 参数
     */
    @Override
    public List<BaseRuleEntityInfo> findBaseRuleEntityListByScene(BaseRuleSceneInfo baseRuleSceneInfo)  {
        //判断参数
        if (null == baseRuleSceneInfo || (StringUtil.isNullOrNullValue(baseRuleSceneInfo.getSceneIdentify()) &&
                null == baseRuleSceneInfo.getSceneId())) {
            throw new ServiceException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }
        //查询数据
        return this.baseRuleSceneEntityRelInfoMapper.findBaseRuleEntityListByScene(baseRuleSceneInfo);
    }
}
