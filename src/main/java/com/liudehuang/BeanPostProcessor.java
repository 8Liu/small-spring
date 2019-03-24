package com.liudehuang;

/**
 * @author liudehuang
 * @date 2019/3/24 16:37
 * bean的后置处理器
 */
public interface BeanPostProcessor {
    /**
     * 在bean实例化、依赖注入完毕，在调用显示的初始化之前完成一些定制的初始化任务
     * @param bean
     * @param beanName
     * @return
     * @throws Exception
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    /**
     * 在bean实例化、依赖注入、初始化完毕时执行
     * @param bean
     * @param beanName
     * @return
     * @throws Exception
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;

}
