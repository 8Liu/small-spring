package com.liudehuang.factory;

import com.liudehuang.BeanDefinition;
import com.liudehuang.BeanPostProcessor;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liudehuang
 * @date 2019/3/24 10:21
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    /**
     * 存放bean的map
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
    /**
     *
     */
    private final List<String> beanDefinitionNames = new ArrayList<>();
    /**
     * bean的后置处理器
     */
    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if(beanDefinition==null){
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if(bean == null){
            bean = doCreateBean(beanDefinition);
            bean = initializeBean(bean,name);
            beanDefinition.setBean(bean);
        }
        return bean;
    }

    /**
     * 处理bean的后置处理器
     * @param bean
     * @param name
     * @return
     * @throws Exception
     */
    protected Object initializeBean(Object bean, String name) throws Exception {
        for(BeanPostProcessor beanPostProcessor:beanPostProcessors){
            bean = beanPostProcessor.postProcessBeforeInitialization(bean,name);
        }
        for(BeanPostProcessor beanPostProcessor:beanPostProcessors){
            bean = beanPostProcessor.postProcessAfterInitialization(bean,name);
        }
        return bean;
    }

    /**
     * 注册bean
     * @param name
     * @param beanDefinition
     * @throws Exception
     */
    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    /**
     * 创建bean实例并给bean实例赋值
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    public abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;

    /**
     * 添加bean的后置处理器
     * @param beanPostProcessor
     * @throws Exception
     */
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) throws Exception {
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * 初始化所有的单实例bean
     * @throws Exception
     */
    public void preInstantiateSingletons() throws Exception {
        for (Iterator it = this.beanDefinitionNames.iterator(); it.hasNext();) {
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }

    /**
     * 获取某个类的bean实例
     * @param type
     * @return
     * @throws Exception
     */
    public List getBeansForType(Class type) throws Exception {
        List beans = new ArrayList<Object>();
        for (String beanDefinitionName : beanDefinitionNames) {
            if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())) {
                beans.add(getBean(beanDefinitionName));
            }
        }
        return beans;
    }
}
