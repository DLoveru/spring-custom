package com.dl.spring.aop;

/**
 * @author Jalen.Deng
 * @description 定义切点，可以看出切点的核心，就是过滤类和匹配方法。
 * @date 2020/11/26 14:53
 **/
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
