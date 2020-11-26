package com.dl.spring.aop;

/**
 * @author Jalen.Deng
 * @description 定义切点 通知
 * @date 2020/11/26 14:54
 **/
public interface PointcutAdvisor extends Advisor{

    Pointcut getPointcut();
}
