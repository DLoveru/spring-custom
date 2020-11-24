package com.dl.spring;

import com.dl.spring.factory.AutowireCapableBeanFactory;
import com.dl.spring.factory.BeanFactory;

/**
 * @author Jalen.Deng
 * @description
 * @date 2020/11/23 21:50
 **/
public class BeanFactoryTest {
    public static void main(String[] args) throws Exception {
        //初始化bean工厂
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.dl.spring.HelloWorldService");
        PropertyValues propertyValues = new PropertyValues();
        //为bean注入属性，name为HelloWorldService定义的属性
        propertyValues.addPropertyValue(new PropertyValue("name","jalen"));
        beanDefinition.setPropertyValues(propertyValues);
        //生成bean
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
        //获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
