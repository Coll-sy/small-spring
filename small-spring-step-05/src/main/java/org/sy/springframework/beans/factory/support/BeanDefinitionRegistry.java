package org.sy.springframework.beans.factory.support;

import org.sy.springframework.beans.factory.config.BeanDefinition;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/9
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface BeanDefinitionRegistry {
    /**
     * 注册Bean接口
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
