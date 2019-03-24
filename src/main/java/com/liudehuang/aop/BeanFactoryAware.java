package com.liudehuang.aop;

import com.liudehuang.factory.BeanFactory;

/**
 * @author liudehuang
 * @date 2019/3/24 17:02
 */
public interface BeanFactoryAware {
    /**
     * 设置beanFactory
     * @param beanFactory
     * @throws Exception
     */
    void setBeanFactory(BeanFactory beanFactory)throws Exception;
}
