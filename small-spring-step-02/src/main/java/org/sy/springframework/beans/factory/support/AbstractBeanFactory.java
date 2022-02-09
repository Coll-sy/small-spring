package org.sy.springframework.beans.factory.support;

import org.sy.springframework.beans.BeansException;
import org.sy.springframework.beans.factory.config.BeanDefinition;
import org.sy.springframework.beans.factory.config.DefaultSingletonBeanRegistry;

/**
 * @description: 抽类实现模板类
 * @author: SunYang
 * @date: 2022/2/9
 * @Copyright： sunyangqaq@foxmail.com
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansException {

        //1.获取单例bean
        Object bean = getSingleton(beanName);
        //2.判断单例是否获取成功 成功返回 否者创建
        if (bean != null) {
            return bean;
        }

        //3.创建该bean
        BeanDefinition beanDefinition = getBeanDefinition(beanName);

        return createBean(beanName, beanDefinition);
    }

    /**
     * 当从已经创建的单例对象中获取不到时，创建一个bean
     * @param beanName bean name
     * @param beanDefinition bean 定义
     * @return 该对象
     * @throws BeansException Beans异常
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    /**
     * 获取一个bean实例
     * @param beanName bean name
     * @return bean实例
     * @throws BeansException Beans异常
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
