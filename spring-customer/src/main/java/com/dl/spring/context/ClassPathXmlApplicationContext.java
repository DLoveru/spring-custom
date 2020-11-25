package com.dl.spring.context;

import com.dl.spring.BeanDefinition;
import com.dl.spring.factory.AbstractBeanFactory;
import com.dl.spring.factory.AutowireCapableBeanFactory;
import com.dl.spring.io.ResourceLoader;
import com.dl.spring.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author Jalen.Deng
 * @description
 * @date 2020/11/25 10:24
 **/
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(new AutowireCapableBeanFactory(), configLocation);
    }

    public ClassPathXmlApplicationContext(AbstractBeanFactory beanFactory, String configLocation) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    /**
     * 使用refresh方法来注册bean
     * @throws Exception
     */
    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
