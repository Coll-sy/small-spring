package org.sy.springframework.core.io;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/14
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 返回Resource
     * @param location 地址
     * @return Resource
     */
    Resource getResource(String location);

}
