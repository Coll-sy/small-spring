package org.sy.springframework.beans.factory;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/2
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface DisposableBean {
    /**
     * 摧毁Bean
     * @throws Exception
     */
    void destroy() throws Exception;
}
