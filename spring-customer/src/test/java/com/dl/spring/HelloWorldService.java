package com.dl.spring;

/**
 * @author Jalen.Deng
 * @description
 * @date 2020/11/23 20:52
 **/
public class HelloWorldService {
    private String name;

    public String getName() {
        return name;
    }

    private OutputService outputService;

    public void setName(String name) {
        this.name = name;
    }

    public void helloWorld() {
        System.out.println(name);
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }

    public OutputService getOutputService() {
        return outputService;
    }
}
