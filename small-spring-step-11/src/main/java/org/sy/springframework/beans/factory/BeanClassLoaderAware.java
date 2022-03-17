package org.sy.springframework.beans.factory;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/3
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface BeanClassLoaderAware extends Aware {
    void setBeanClassLoader(ClassLoader classLoader);
}
