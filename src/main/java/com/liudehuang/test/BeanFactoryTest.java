package com.liudehuang.test;

import com.liudehuang.BeanDefinition;
import com.liudehuang.context.ApplicationContext;
import com.liudehuang.context.ClassPathXmlApplicationContext;
import com.liudehuang.factory.AbstractBeanFactory;
import com.liudehuang.factory.AutowireCapableBeanFactory;
import com.liudehuang.io.ResourceLoader;
import com.liudehuang.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * @author liudehuang
 * @date 2019/3/24 11:24
 */
public class BeanFactoryTest {
    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("testIoc.xml");
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for(Map.Entry<String, BeanDefinition> beanDefinitionEntry:xmlBeanDefinitionReader.getRegistry().entrySet()){
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        System.out.println(helloWorldService.getText());
    }

    @Test
    public void contextTest()throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("testIoc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) context.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
