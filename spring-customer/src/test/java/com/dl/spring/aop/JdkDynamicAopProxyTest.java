package com.dl.spring.aop;

import com.dl.spring.HelloWorldService;
import com.dl.spring.context.ApplicationContext;
import com.dl.spring.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author Jalen.Deng
 * @description
 * @date 2020/11/26 14:08
 **/
public class JdkDynamicAopProxyTest {
    @Test
    public void testInterceptor() throws Exception {
        //不使用AOP
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        HelloWorldService helloWorldService = (HelloWorldService) context.getBean("helloWorldService");
        helloWorldService.helloWorld();

        //使用AOP

        //设置被代理对象（JoinPoint切点）
        AdvisedSupport advisedSupport =new AdvisedSupport();
        TargetSource targetSource = new TargetSource(HelloWorldService.class,helloWorldService);
        advisedSupport.setTargetSource(targetSource);

        //设置拦截器（Advise通知）
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        //创建代理对象
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        HelloWorldService proxy = (HelloWorldService) jdkDynamicAopProxy.getProxy();
        //基于AOP的调用
        proxy.helloWorld();
    }
}
