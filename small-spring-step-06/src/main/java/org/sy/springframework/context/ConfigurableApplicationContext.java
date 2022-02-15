package org.sy.springframework.context;

import org.sy.springframework.beans.BeansException;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/15
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新
     * @throws BeansException BeansException
     */
    void refresh() throws BeansException;
}
