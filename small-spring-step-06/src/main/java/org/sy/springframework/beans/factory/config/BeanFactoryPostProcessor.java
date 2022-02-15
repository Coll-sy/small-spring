package org.sy.springframework.beans.factory.config;

import org.sy.springframework.beans.BeansException;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/15
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     * @param beanFactory beanFactory工厂
     * @throws BeansException Bean异常
     */
    void postProcessBeanFactory(ConfigurableBeanFactory beanFactory) throws BeansException;
}
