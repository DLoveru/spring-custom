package com.dl.spring.aop;

/**
 * @author Jalen.Deng
 * @description 类过滤器
 * @date 2020/11/26 14:40
 **/
public interface ClassFilter {

    boolean matches(Class targetClass);
}
