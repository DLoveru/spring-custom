package com.dl.spring.aop;

import org.aopalliance.aop.Advice;

/**
 * @author Jalen.Deng
 * @description 定义通知
 * @date 2020/11/26 14:55
 **/
public interface Advisor {
    Advice getAdvice();
}
