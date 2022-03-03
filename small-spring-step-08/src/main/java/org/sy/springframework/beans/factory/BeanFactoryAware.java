package org.sy.springframework.beans.factory;

import org.sy.springframework.beans.BeansException;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/3
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
