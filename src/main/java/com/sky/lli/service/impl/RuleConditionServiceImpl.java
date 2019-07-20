package com.sky.lli.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.lli.dao.BaseRuleConditionInfoMapper;
import com.sky.lli.exception.ExceptionEnum;
import com.sky.lli.exception.ServiceException;
import com.sky.lli.model.BaseRuleConditionInfo;
import com.sky.lli.service.RuleConditionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleConditionServiceImpl
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/24
 */
@Service
public class RuleConditionServiceImpl implements RuleConditionService {

    @Resource
    private BaseRuleConditionInfoMapper baseRuleConditionInfoMapper;

    /**
     * Date 2017/7/24
     * Author lihao [lihao@sinosoft.com]
     * <p>
     * 方法说明: 根据规则获取规则条件信息
     *
     * @param baseRuleConditionInfo 参数
     * @param page                  分页参数
     */
    @Override
    public PageInfo<BaseRuleConditionInfo> findBaseRuleConditionInfoPage(BaseRuleConditionInfo baseRuleConditionInfo, PageInfo page) {

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<BaseRuleConditionInfo> list = this.baseRuleConditionInfoMapper.findBaseRuleConditionInfoList(baseRuleConditionInfo);
        return new PageInfo<>(list);
    }

    /**
     * Date 2017/7/26
     * Author lihao [lihao@sinosoft.com]
     * <p>
     * 方法说明: 根据规则id获取规则条件信息
     *
     * @param ruleId 规则id
     */
    @Override
    public List<BaseRuleConditionInfo> findRuleConditionInfoByRuleId(Long ruleId) {
        if (null == ruleId) {
            throw new ServiceException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }
        return this.baseRuleConditionInfoMapper.findRuleConditionInfoByRuleId(ruleId, null);
    }
}
