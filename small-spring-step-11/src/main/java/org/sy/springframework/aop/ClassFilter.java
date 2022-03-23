package org.sy.springframework.aop;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/23
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
