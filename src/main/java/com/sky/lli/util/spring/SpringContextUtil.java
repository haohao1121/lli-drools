package com.sky.lli.util.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import java.io.Serializable;
import java.util.Map;

/**
 * 描述：Spring上下文工具类
 * CLASSPATH: com.sky.lli.util.spring.SpringContextUtil.java
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/11/20
 */
public class SpringContextUtil implements Serializable {

    private SpringContextUtil() {
    }

    /**
     * Spring应用上下文环境
     */
    private static ApplicationContext applicationContext;


    public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * 根据beanName获取bean
     *
     * @param name beanName
     * @return bean的实例
     * @throws BeansException BeansException
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBeanByName(String name) throws BeansException {
        return applicationContext == null ? null : (T) applicationContext.getBean(name);
    }

    /**
     * 根据beanName获取bean
     *
     * @param name beanName
     * @param T    获取bean的类型
     * @return bean的实例
     * @throws BeansException BeansException
     */
    public static <T> T getBean(String name, Class<T> T) throws BeansException {
        return applicationContext == null ? null : applicationContext.getBean(name, T);
    }

    /**
     * 根据beanName获取bean
     *
     * @param T 获取bean的类型
     * @return bean的实例
     * @throws BeansException BeansException
     */
    public static <T> T getBeanByClass(Class<T> T) throws BeansException {
        return applicationContext == null ? null : applicationContext.getBean(T);
    }

    /**
     * Date 2017/9/29
     * Author lihao [lihao@sinosoft.com.cn]
     * <p>
     * 方法说明: 根据接口获取所有的实现类bean
     *
     * @param clazz 接口类
     * @return 接口实现类bean集合
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        @SuppressWarnings("rawtypes")
        Map<String, T> beanMaps = applicationContext.getBeansOfType(clazz);
        if (beanMaps != null && !beanMaps.isEmpty()) {
            return beanMaps;
        } else {
            return null;
        }
    }
}
