package com.sky.lli.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.lli.dao.BaseRuleInfoMapper;
import com.sky.lli.exception.ExceptionEnum;
import com.sky.lli.exception.ServiceException;
import com.sky.lli.model.BaseRuleInfo;
import com.sky.lli.model.BaseRulePropertyInfo;
import com.sky.lli.model.BaseRulePropertyRelInfo;
import com.sky.lli.model.BaseRuleSceneInfo;
import com.sky.lli.service.RuleInfoService;
import com.sky.lli.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleInfoServiceImpl
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/25
 */
@Service
public class RuleInfoServiceImpl implements RuleInfoService {

    @Resource
    private BaseRuleInfoMapper baseRuleInfoMapper;

    /**
     * Date 2017/7/25
     * Author lihao [lihao@sinosoft.com]
     * <p>
     * 方法说明: 获取规则集合信息
     *
     * @param baseRuleInfo 参数
     * @param page         分页参数
     */
    @Override
    public PageInfo<BaseRuleInfo> findBaseRuleInfoPage(BaseRuleInfo baseRuleInfo, PageInfo page) {

        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<BaseRuleInfo> list = this.baseRuleInfoMapper.findBaseRuleInfoList(baseRuleInfo);
        return new PageInfo<>(list);
    }

    /**
     * Date 2017/7/25
     * Author lihao [lihao@sinosoft.com]
     * <p>
     * 方法说明: 查询规则属性信息
     *
     * @param baseRulePropertyInfo 参数
     */
    @Override
    public List<BaseRulePropertyInfo> findBaseRulePropertyInfoList(BaseRulePropertyInfo baseRulePropertyInfo) {
        return this.baseRuleInfoMapper.findBaseRulePropertyInfoList(baseRulePropertyInfo);
    }

    /**
     * Date 2017/7/25
     * Author lihao [lihao@sinosoft.com]
     * <p>
     * 方法说明: 根据规则获取已经配置的属性信息
     *
     * @param ruleId 参数
     */
    @Override
    public List<BaseRulePropertyRelInfo> findRulePropertyListByRuleId(final Long ruleId) {
        return this.baseRuleInfoMapper.findRulePropertyListByRuleId(ruleId);
    }

    /**
     * Date 2017/7/26
     * Author lihao [lihao@sinosoft.com]
     * <p>
     * 方法说明: 根据场景获取对应的规则规则信息
     *
     * @param baseRuleSceneInfo 参数
     */
    @Override
    public List<BaseRuleInfo> findBaseRuleListByScene(BaseRuleSceneInfo baseRuleSceneInfo) {
        if (null == baseRuleSceneInfo || (null == baseRuleSceneInfo.getSceneId() &&
                StringUtil.isNullOrNullValue(baseRuleSceneInfo.getSceneIdentify()))) {
            throw new ServiceException(ExceptionEnum.REQUEST_PARAM_MISSING);
        }

        return this.baseRuleInfoMapper.findBaseRuleListByScene(baseRuleSceneInfo);
    }
}
