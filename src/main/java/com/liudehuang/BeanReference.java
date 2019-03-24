package com.liudehuang;

/**
 * @author liudehuang
 * @date 2019/3/24 17:10
 */
public class BeanReference {

    private String name;

    private Object bean;

    public BeanReference(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
