package com.liudehuang;

/**
 * @author liudehuang
 * @date 2019/3/24 10:18
 * 定义bean的元数据
 */
public class BeanDefinition {

    private Object bean;

    private Class beanClass;

    private String beanClassName;
    /**
     * bean的属性
     */
    private PropertyValues propertyValues = new PropertyValues();

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
