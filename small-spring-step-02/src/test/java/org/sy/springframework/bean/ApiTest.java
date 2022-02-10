package org.sy.springframework.bean;

import org.junit.Test;
import org.sy.springframework.bean.bean.UserService;
import org.sy.springframework.bean.factory.config.BeanDefinition;
import org.sy.springframework.bean.factory.support.DefaultListableBeanFactory;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/9
 * @Copyright： sunyangqaq@foxmail.com
 */
public class ApiTest {
    @Test
    public void test_BeanFactory() throws BeansException {
        // 1.初始化beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册bean
        beanFactory.registryBeanDefinition("userService", new BeanDefinition(UserService.class));
        // 3.第一次获取bean
        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 4.第二次获取bean 验证singleton
        UserService userService_2 = (UserService)beanFactory.getBean("userService");
        userService_2.queryUserInfo();
        System.out.println(userService);
        System.out.println(userService_2);
    }
}
