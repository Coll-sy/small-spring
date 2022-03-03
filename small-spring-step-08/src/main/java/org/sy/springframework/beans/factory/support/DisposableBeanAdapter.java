package org.sy.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import org.sy.springframework.beans.BeansException;
import org.sy.springframework.beans.factory.DisposableBean;
import org.sy.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/2
 * @Copyright： sunyangqaq@foxmail.com
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }
        if (StrUtil.isNotEmpty(destroyMethodName)) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}
