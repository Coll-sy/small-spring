package org.sy.springframework.beans.factory.config;

import org.sy.springframework.beans.BeansException;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/15
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface BeanPostProcessor {

    /**
     * 在Bean对象执行初始化方法之前，执行此方法
     * @param bean bean
     * @param beanName beanName
     * @return Object
     * @throws BeansException BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在Bean对象执行初始化方法之后，执行此方法
     * @param bean bean
     * @param beanName beanName
     * @return Object
     * @throws BeansException BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
