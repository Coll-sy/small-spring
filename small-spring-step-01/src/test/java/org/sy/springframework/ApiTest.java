package org.sy.springframework;

import org.junit.Test;
import org.sy.springframework.beans.UserService;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/9
 * @Copyright： sunyangqaq@foxmail.com
 */
public class ApiTest {

    @Test
    public void test_beanFactory() {
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}

