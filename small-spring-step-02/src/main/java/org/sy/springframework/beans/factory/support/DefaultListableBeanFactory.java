package org.sy.springframework.beans.factory.support;

import org.sy.springframework.beans.BeansException;
import org.sy.springframework.beans.factory.config.BeanDefinition;
import org.sy.springframework.beans.factory.config.SingletonBeanRegistry;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/9
 * @Copyright： sunyangqaq@foxmail.com
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements SingletonBeanRegistry {


    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        return null;
    }
}
