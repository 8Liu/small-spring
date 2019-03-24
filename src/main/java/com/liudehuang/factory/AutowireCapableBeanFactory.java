package com.liudehuang.factory;

import com.liudehuang.BeanDefinition;
import com.liudehuang.BeanReference;
import com.liudehuang.PropertyValue;
import com.liudehuang.aop.BeanFactoryAware;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author liudehuang
 * @date 2019/3/24 10:30
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{
    /**
     * 创建bean实例
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    @Override
    public Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = beanDefinition.getBeanClass().newInstance();
        beanDefinition.setBean(bean);
        applyPropertyValues(bean,beanDefinition);
        return bean;
    }

    /**
     * 给bean实例赋值
     * @param bean
     * @param beanDefinition
     * @throws Exception
     */
    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition)throws Exception {
        //如果bean实现了BeanFactoryAware,设置该bean工厂的类型为this
        if(bean instanceof BeanFactoryAware){
            ((BeanFactoryAware)bean).setBeanFactory(this);
        }
        for(PropertyValue propertyValue:beanDefinition.getPropertyValues().getPropertyValues()){
            Object value = propertyValue.getValue();
            if(value instanceof BeanReference){
                BeanReference beanReference = (BeanReference)value;
                value = getBean(beanReference.getName());
            }

            try {
                Method declaredMethod = bean.getClass().getDeclaredMethod("set"+propertyValue.getName().substring(0,1).toUpperCase()+propertyValue.getName().substring(1),value.getClass());
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(bean,value);
            }catch (NoSuchMethodException e){
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }
        }
    }


}
