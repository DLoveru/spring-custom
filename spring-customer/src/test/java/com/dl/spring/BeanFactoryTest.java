package com.dl.spring;

import com.dl.spring.factory.AutowireCapableBeanFactory;
import com.dl.spring.factory.BeanFactory;

/**
 * @author Jalen.Deng
 * @description
 * @date 2020/11/23 21:50
 **/
public class BeanFactoryTest {
    public static void main(String[] args) {
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.dl.spring.HelloWorldService");
        beanFactory.registerBeanDefinition("helloWorldService",beanDefinition);
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
