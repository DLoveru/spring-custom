package com.dl.spring;

import com.dl.spring.factory.AutowireCapableBeanFactory;
import com.dl.spring.factory.BeanFactory;
import com.dl.spring.io.ResourceLoader;
import com.dl.spring.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author Jalen.Deng
 * @description
 * @date 2020/11/23 21:50
 **/
public class BeanFactoryTest {
    public static void main(String[] args) throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("spring.xml");

        // 2.初始化BeanFactory并注册bean
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
