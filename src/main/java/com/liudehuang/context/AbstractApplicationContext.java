package com.liudehuang.context;

import com.liudehuang.BeanDefinition;
import com.liudehuang.BeanPostProcessor;
import com.liudehuang.factory.AbstractBeanFactory;

import java.util.List;

/**
 * @author liudehuang
 * @date 2019/3/24 13:18
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory){
        this.beanFactory = beanFactory;
    }



    public void refresh() throws Exception {
        loadBeanDefinitions(beanFactory);
        registerBeanPostProcessors(beanFactory);
        onRefresh();
    }

    /**
     * 注册bean的后置处理器
     * @param beanFactory
     * @throws Exception
     */
    protected void registerBeanPostProcessors(AbstractBeanFactory beanFactory)throws Exception{
        List beanPostProcessors = beanFactory.getBeansForType(BeanPostProcessor.class);
        for (Object beanPostProcessor : beanPostProcessors) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }

    protected abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory)throws Exception;

    /**
     * 初始化所有的单例bean
     * @throws Exception
     */
    protected void onRefresh() throws Exception{
        beanFactory.preInstantiateSingletons();
    }


    @Override
    public Object getBean(String beanName) throws Exception {
        return beanFactory.getBean(beanName);
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {

    }
}
