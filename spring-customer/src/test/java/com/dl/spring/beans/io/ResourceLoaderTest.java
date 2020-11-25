package com.dl.spring.beans.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Jalen.Deng
 * @description 使用resource读取配置文件
 * @date 2020/11/24 14:42
 **/
public class ResourceLoaderTest {

	@Test
	public void test() throws IOException {
		ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("spring.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }
}
