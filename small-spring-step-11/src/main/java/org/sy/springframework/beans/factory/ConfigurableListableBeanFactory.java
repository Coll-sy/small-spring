package org.sy.springframework.beans.factory;

import org.sy.springframework.beans.BeansException;
import org.sy.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.sy.springframework.beans.factory.config.BeanDefinition;
import org.sy.springframework.beans.factory.config.BeanPostProcessor;
import org.sy.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/15
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons();

    @Override
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
