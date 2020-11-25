package com.dl.spring;

/**
 * @author Jalen.Deng
 * @description bean引用，用于处理bean之间相互依赖
 * @date 2020/11/25 9:01
 **/
public class BeanReference {
    private String name;

    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
