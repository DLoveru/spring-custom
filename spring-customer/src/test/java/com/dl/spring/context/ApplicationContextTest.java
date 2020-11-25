package com.dl.spring.context;

import com.dl.spring.HelloWorldService;
import org.junit.Test;

/**
 * @author Jalen.Deng
 * @description
 * @date 2020/11/23 21:50
 **/
public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
