package com.liudehuang;

/**
 * @author liudehuang
 * @date 2019/3/24 10:54
 * 定义读取bean定义文件，职责分离
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}
