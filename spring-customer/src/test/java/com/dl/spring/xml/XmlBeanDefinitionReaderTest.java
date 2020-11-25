package com.dl.spring.xml;

import com.dl.spring.BeanDefinition;
import com.dl.spring.io.ResourceLoader;
import org.junit.Test;

import java.util.Map;

/**
 * @author Jalen.Deng
 * @description 测试读取配置文件
 * @date 2020/11/24 14:42
 **/
public class XmlBeanDefinitionReaderTest {

    public static void main(String[] args) throws Exception{
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("spring.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        System.out.println(registry.get("helloWorldService"));
    }
    @Test
    public void test() throws Exception{
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("spring.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        System.out.println(registry.get("helloWorldService"));
    }
}

