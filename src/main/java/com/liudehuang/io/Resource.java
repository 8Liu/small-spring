package com.liudehuang.io;

import java.io.InputStream;

/**
 * @author liudehuang
 * @date 2019/3/24 10:05
 * 用于定义资源的获取
 */
public interface Resource {
    InputStream getInputStream() throws Exception;
}
