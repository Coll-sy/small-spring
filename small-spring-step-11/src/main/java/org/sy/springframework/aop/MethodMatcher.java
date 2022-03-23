package org.sy.springframework.aop;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/23
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
