package org.sy.springframework.test;

import org.junit.Test;
import org.sy.springframework.beans.factory.PropertyValue;
import org.sy.springframework.beans.factory.PropertyValues;
import org.sy.springframework.beans.factory.config.BeanDefinition;
import org.sy.springframework.beans.factory.config.BeanReference;
import org.sy.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.sy.springframework.test.bean.UserDao;
import org.sy.springframework.test.bean.UserService;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/10
 * @Copyright： sunyangqaq@foxmail.com
 */
public class ApiTest {
    @Test
    public void test_BeanFactory() {
        // 1.初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册UserDAO
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService设置属性
        PropertyValues propertyValues = new PropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("uId","10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.获取bean

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
