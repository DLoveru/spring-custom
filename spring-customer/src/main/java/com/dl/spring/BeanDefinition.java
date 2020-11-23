package com.dl.spring;

/**
 * @author Jalen.Deng
 * @description bean定义，可以理解为层层包装后的bean
 * @date 2020/11/23 20:46
 **/
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
