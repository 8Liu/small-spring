package com.liudehuang;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liudehuang
 * @date 2019/3/24 10:38
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues(){

    }

    public void addPropertyValue(PropertyValue propertyValue){
        this.propertyValueList.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues(){
        return this.propertyValueList;
    }
}
