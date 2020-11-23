package com.dl.spring;

/**
 * @author Jalen.Deng
 * @description
 * @date 2020/11/23 20:51
 **/
public class BeanFactoryTest {
    public static void main(String[] args) {
        //初始化beanFactory
        BeanFactory beanFactory = new BeanFactory();
        //创建bean实例
        BeanDefinition helloWorldServiceBean = new BeanDefinition(new HelloWorldService());
        //注册bean实例到beanFactory
        beanFactory.registerBeanDefinition("helloWorldService",helloWorldServiceBean);
        //通过getBean()方法获取bean实例
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        //调用hello方法
        helloWorldService.helloWorld();
    }
}
