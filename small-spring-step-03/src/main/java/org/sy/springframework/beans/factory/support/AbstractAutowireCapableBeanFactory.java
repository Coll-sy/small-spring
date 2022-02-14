package org.sy.springframework.beans.factory.support;

import org.sy.springframework.beans.BeansException;
import org.sy.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @description:实例化Bean类 即能创建Bean
 * @author: SunYang
 * @date: 2022/2/9
 * @Copyright： sunyangqaq@foxmail.com
 * todo 构造函数入参的对象怎么处理？？
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor<?> constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declareConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declareConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return instantiationStrategy.instantiation(beanDefinition, beanName, constructorToUse, args);
    }
}
