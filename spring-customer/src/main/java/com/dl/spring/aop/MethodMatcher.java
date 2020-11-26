package com.dl.spring.aop;

import java.lang.reflect.Method;

/**
 * @author Jalen.Deng
 * @description 方法匹配器
 * @date 2020/11/26 14:40
 **/
public interface MethodMatcher {

    boolean matches(Method method, Class targetClass);
}
