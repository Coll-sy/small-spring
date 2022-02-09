package org.sy.springframework.beans.factory.support;

import org.sy.springframework.beans.BeansException;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/9
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface BeanFactory {
    /**
     * 获取Bean
     * @param beanName bean name
     * @return Object
     */
    Object getBean(String beanName) throws BeansException;

}
