package com.dl.spring;

/**
 * @author Jalen.Deng
 * @description 为bean注入属性
 * @date 2020/11/24 9:09
 **/
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
