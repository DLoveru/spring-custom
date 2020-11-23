package com.dl.spring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jalen.Deng
 * @description bean工厂-最基本的容器
 * @date 2020/11/23 20:36
 **/
public class BeanFactory {
    //创建beanDefinitionMap来存储bean的实例
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    /**
     * 注册bean到beanDefinitionMap中
     * @param name
     * @param beanDefinition
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
