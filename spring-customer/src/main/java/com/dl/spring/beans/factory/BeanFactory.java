package com.dl.spring.beans.factory;

/**
 * @author Jalen.Deng
 * @description 定义BeanFactory工厂接口
 * @date 2020/11/23 20:36
 **/
public interface BeanFactory {

    /**
     * 通过beanName获取bean实例
     * @param name
     * @return
     */
     Object getBean(String name) throws Exception;

}
