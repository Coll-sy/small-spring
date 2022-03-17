package org.sy.springframework.test.common;

import org.sy.springframework.beans.BeansException;
import org.sy.springframework.beans.factory.config.BeanPostProcessor;
import org.sy.springframework.test.bean.UserService;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/17
 * @Copyright： sunyangqaq@foxmail.com
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
