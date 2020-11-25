package com.dl.spring.context;

import com.dl.spring.factory.AbstractBeanFactory;
/**
 * @author Jalen.Deng
 * @description
 * @date 2020/11/25 10:13
 **/
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception{
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
