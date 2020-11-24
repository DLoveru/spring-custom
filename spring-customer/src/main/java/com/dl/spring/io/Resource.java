package com.dl.spring.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Jalen.Deng
 * @description Resource是spring内部定位资源的接口。
 * @date 2020/11/24 14:34
 **/
public interface Resource {
    InputStream getInputStream() throws IOException;
}
