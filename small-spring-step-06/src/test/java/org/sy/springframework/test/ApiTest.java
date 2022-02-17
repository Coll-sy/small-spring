package org.sy.springframework.test;

import cn.hutool.core.io.IoUtil;
import org.junit.Before;
import org.junit.Test;
import org.sy.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.sy.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.sy.springframework.context.support.ClassPathXmlApplicationContext;
import org.sy.springframework.core.io.DefaultResourceLoader;
import org.sy.springframework.core.io.Resource;
import org.sy.springframework.test.bean.UserService;
import org.sy.springframework.test.common.MyBeanFactoryPostProcessor;
import org.sy.springframework.test.common.MyBeanPostProcessor;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/10
 * @Copyright： sunyangqaq@foxmail.com
 */
public class ApiTest {

    @Test
    public void test_BeanFactoryPostProcessorAndBeanProcessor() {
        // 1.初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.读取配置文件并注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");
        // 3.BeanDefinition 加载完成 & Bean实例化之前，修改BeanDefinition的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        // 4.Bean实例化后，修改Bean属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);
        // 5. 获取Bean对象调用方法

        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果: "+result);
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
