package com.dl.spring.factory;

import com.dl.spring.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jalen.Deng
 * @description 定义BeanFactory工厂接口
 * @date 2020/11/23 20:36
 **/
public interface BeanFactory {

    /**
     * 通过beanName获取bean实例
     * @param name
     * @return
     */
     Object getBean(String name);

    /**
     * 注册bean到beanDefinitionMap中
     * @param name
     * @param beanDefinition
     */
     void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
