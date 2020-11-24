package com.dl.spring;

import com.dl.spring.io.ResourceLoader;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jalen.Deng
 * @description
 * @date 2020/11/24 14:43
 **/
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
    //存储bean定义信息的map
    private Map<String,BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new ConcurrentHashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
