package org.sy.springframework.test;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import org.sy.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.sy.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.sy.springframework.context.support.ClassPathXmlApplicationContext;
import org.sy.springframework.test.bean.UserService;
import org.sy.springframework.test.common.MyBeanFactoryPostProcessor;
import org.sy.springframework.test.common.MyBeanPostProcessor;
import org.sy.springframework.test.event.CustomEvent;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/10
 * @Copyright： sunyangqaq@foxmail.com
 */
public class ApiTest {
    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }
}
