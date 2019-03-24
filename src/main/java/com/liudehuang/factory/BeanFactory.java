package com.liudehuang.factory;

import com.liudehuang.BeanDefinition;

/**
 * @author liudehuang
 * @date 2019/3/24 10:16
 * 定义了BeanFactory的基本方法
 */
public interface BeanFactory {
    /**
     * 获取bean
     * @param beanName
     * @return
     */
    Object getBean(String beanName) throws Exception;

    /**
     * 注册bean
     * @param name
     * @throws Exception
     */
    void registerBeanDefinition(String name, BeanDefinition beanDefinition)throws Exception;


}
