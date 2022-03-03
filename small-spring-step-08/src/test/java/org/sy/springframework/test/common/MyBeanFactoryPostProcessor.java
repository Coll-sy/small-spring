package org.sy.springframework.test.common;

import org.sy.springframework.beans.BeansException;
import org.sy.springframework.beans.PropertyValue;
import org.sy.springframework.beans.PropertyValues;
import org.sy.springframework.beans.factory.ConfigurableListableBeanFactory;
import org.sy.springframework.beans.factory.config.BeanDefinition;
import org.sy.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/17
 * @Copyright： sunyangqaq@foxmail.com
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为字节跳动"));
    }
}
