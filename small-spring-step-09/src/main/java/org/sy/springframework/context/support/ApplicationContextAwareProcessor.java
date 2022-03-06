package org.sy.springframework.context.support;

import org.sy.springframework.beans.BeansException;
import org.sy.springframework.beans.factory.config.BeanPostProcessor;
import org.sy.springframework.context.ApplicationContext;
import org.sy.springframework.context.ApplicationContextAware;

/**
 * @description: ApplicationContext对象需要在bean完成时注入，因为bean在ApplicationContext中完成
 * @author: SunYang
 * @date: 2022/3/3
 * @Copyright： sunyangqaq@foxmail.com
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
