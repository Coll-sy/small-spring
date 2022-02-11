package test;

import org.junit.Test;
import org.sy.springframework.bean.factory.config.BeanDefinition;
import org.sy.springframework.bean.factory.support.DefaultListableBeanFactory;
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
        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registryBeanDefinition("userService", beanDefinition);
        // 3.获取bean

        UserService userService = (UserService) beanFactory.getBean("userService", "孙杨");
        userService.queryUserInfo();
    }
}
