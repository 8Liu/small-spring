package com.liudehuang.io;

import java.net.URL;

/**
 * @author liudehuang
 * @date 2019/3/24 10:11
 */
public class ResourceLoader {
    public Resource getResource(String location){
        URL url = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(url);
    }
}
