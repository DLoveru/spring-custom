package com.dl.spring.beans.io;

import java.net.URL;

/**
 * @author Jalen.Deng
 * @description 资源加载器
 * @date 2020/11/24 14:35
 **/
public class ResourceLoader {
    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
