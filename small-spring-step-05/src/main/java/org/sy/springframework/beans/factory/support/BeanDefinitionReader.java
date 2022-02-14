package org.sy.springframework.beans.factory.support;

import org.sy.springframework.beans.BeansException;
import org.sy.springframework.core.io.Resource;
import org.sy.springframework.core.io.ResourceLoader;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/14
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface BeanDefinitionReader {

    /**
     * 返回BeanDefinition注册器（为load服务 抽象类隔离）
     * @return BeanDefinitionRegistry
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 返回资源加载器（为load服务 抽象类隔离）
     * @return ResourceLoader
     */
    ResourceLoader getResourceLoader();

    /**
     * 通过一个资源加载Bean定义
     * @param resource 资源
     * @throws BeansException 加载异常
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * 通过多个资源加载Bean定义
     * @param resources 资源
     * @throws BeansException 加载异常
     */
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * 通过资源地址加载Bean定义
     * @param location 地址
     * @throws BeansException 加载异常
     */
    void loadBeanDefinitions(String location) throws BeansException;


}
