package com.liudehuang;

import com.liudehuang.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liudehuang
 * @date 2019/3/24 10:59
 * 模板类
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    /**
     * 缓存配置文件中的所有的bean
     */
    private Map<String,BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader){
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }


}
