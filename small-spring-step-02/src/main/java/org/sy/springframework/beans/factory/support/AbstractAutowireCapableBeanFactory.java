package org.sy.springframework.beans.factory.support;

import org.sy.springframework.beans.BeansException;
import org.sy.springframework.beans.factory.config.BeanDefinition;

/**
 * @description:实例化Bean类 即能创建Bean
 * @author: SunYang
 * @date: 2022/2/9
 * @Copyright： sunyangqaq@foxmail.com
 * todo 构造函数入参的对象怎么处理？？
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }
}
