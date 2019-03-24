package com.liudehuang.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author liudehuang
 * @date 2019/3/24 10:07
 * 通过url获取Resource流
 */
public class UrlResource implements Resource {
    private final URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    public InputStream getInputStream() throws Exception {
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
