package org.sy.springframework.beans.factory;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/3
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String name);

}
