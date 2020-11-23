package com.dl.spring.factory;

import com.dl.spring.BeanDefinition;

/**
 * @author Jalen.Deng
 * @description
 * @date 2020/11/23 21:35
 **/
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
