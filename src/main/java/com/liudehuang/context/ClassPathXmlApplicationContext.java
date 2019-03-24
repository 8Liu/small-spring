package com.liudehuang.context;

import com.liudehuang.BeanDefinition;
import com.liudehuang.factory.AbstractBeanFactory;
import com.liudehuang.factory.AutowireCapableBeanFactory;
import com.liudehuang.io.ResourceLoader;
import com.liudehuang.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author liudehuang
 * @date 2019/3/24 17:29
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
    /**
     * 配置文件位置
     */
    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation,AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    public ClassPathXmlApplicationContext(String configLocation)throws Exception{
        this(configLocation,new AutowireCapableBeanFactory());
    }

    @Override
    protected void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
