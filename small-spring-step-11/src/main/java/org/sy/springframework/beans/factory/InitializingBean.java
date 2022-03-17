package org.sy.springframework.beans.factory;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/2
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface InitializingBean {
    /**
     * Bean 处理了属性填充后调用
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
