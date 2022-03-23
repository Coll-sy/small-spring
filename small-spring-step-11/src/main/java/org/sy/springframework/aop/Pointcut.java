package org.sy.springframework.aop;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/23
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface Pointcut {

    /**
     * 返回 Pointcut 的 ClassFilter
     * @return ClassFilter
     */
    ClassFilter getClassFilter();

    /**
     * 返回 Pointcut 的 MethodMatcher
     * @return MethodMatcher
     */
    MethodMatcher getMethodMatcher();

}
