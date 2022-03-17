package org.sy.springframework.context.support;

import org.sy.springframework.beans.BeansException;
import org.sy.springframework.beans.factory.ConfigurableListableBeanFactory;
import org.sy.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/16
 * @Copyright： sunyangqaq@foxmail.com
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);


    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
