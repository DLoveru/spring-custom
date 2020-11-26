package com.dl.spring.aop;

import org.aopalliance.aop.Advice;

/**
 * @author Jalen.Deng
 * @description 切点表达式-通知实现类
 * @date 2020/11/26 15:06
 **/
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor{

    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    private Advice advice;

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression) {
        this.pointcut.setExpression(expression);
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }
}
