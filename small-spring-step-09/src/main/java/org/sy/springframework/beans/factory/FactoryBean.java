package org.sy.springframework.beans.factory;

/**
 * @description: 简单工厂Bean，此bean只是获取相关对象的工厂，供外界实现
 * @author: SunYang
 * @date: 2022/3/6
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
