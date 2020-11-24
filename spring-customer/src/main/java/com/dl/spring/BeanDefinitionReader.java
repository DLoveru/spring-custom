package com.dl.spring;

/**
 * @author Jalen.Deng
 * @description 从配置中读取BeanDefinitionReader
 * @date 2020/11/24 14:43
 **/
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
