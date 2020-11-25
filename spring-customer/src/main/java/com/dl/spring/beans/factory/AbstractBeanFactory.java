package com.dl.spring.beans.factory;

import com.dl.spring.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jalen.Deng
 * @description 抽象bean工厂
 * @date 2020/11/23 21:31
 **/
public abstract class AbstractBeanFactory implements BeanFactory {
    /**
     *创建beanDefinitionMap来存储bean的实例
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    private final List<String> beanDefinitionNames = new ArrayList<String>();

    @Override
    public Object getBean(String name) throws Exception{
        /**
         * ，我们使用lazy-init的方式，将createBean的事情放到`getBean`的时候才执行，
         * 这样在注入bean的时候，如果该属性对应的bean找不到，那么就先创建
         * 因为总是先创建后注入，所以不会存在两个循环依赖的bean创建死锁的问题。
         */
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }
    /**
     * 注册bean到beanDefinitionMap中
     * @param name
     * @param beanDefinition
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }
    //初始化bean单例
    public void preInstantiateSingletons() throws Exception {
        for (Iterator it = this.beanDefinitionNames.iterator(); it.hasNext();) {
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }

    /**
     * 初始化bean
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
