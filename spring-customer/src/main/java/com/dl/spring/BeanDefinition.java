package com.dl.spring;

/**
 * @author Jalen.Deng
 * @description bean定义，可以理解为层层包装后的bean。
 * @date 2020/11/23 20:46
 **/
public class BeanDefinition {
    private Object bean;

    private Class beanClass;

    private String beanClassName;

    public BeanDefinition() {
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Object getBean() {
        return bean;
    }
}
