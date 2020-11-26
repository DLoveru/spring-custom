package com.dl.spring.aop;

/**
 * @author Jalen.Deng
 * @description 被代理的对象
 * @date 2020/11/26 9:50
 **/
public class TargetSource {

    private Class targetClass;
    private Object target;

    public TargetSource(Class<?> targetClass, Object target) {
        this.targetClass = targetClass;
        this.target = target;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }
}
