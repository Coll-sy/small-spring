package org.sy.springframework.bean.factory.support;

import org.sy.springframework.bean.BeansException;
import org.sy.springframework.bean.factory.BeanFactory;
import org.sy.springframework.bean.factory.config.BeanDefinition;

/**
 * @description: 抽类实现模板类, 其他实现类定义创建bean方法
 * @author: SunYang
 * @date: 2022/2/9
 * @Copyright： sunyangqaq@foxmail.com
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    protected <T> T doGetBean(final String beanName, final Object[] args) {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return (T) createBean(beanName, beanDefinition, args);
    }

    /**
     * 当从已经创建的单例对象中获取不到时，创建一个bean
     *
     * @param beanName       bean name
     * @param beanDefinition bean 定义
     * @param args           构造方法参数
     * @return 该对象
     * @throws BeansException Beans异常
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    /**
     * 获取一个bean实例
     *
     * @param beanName bean name
     * @return bean实例
     * @throws BeansException Beans异常
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
