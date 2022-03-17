package org.sy.springframework.util;

import org.sy.springframework.context.ApplicationListener;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/14
 * @Copyright： sunyangqaq@foxmail.com
 */
public class ClassUtils {
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        if (cl == null) {
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }

    public static boolean isCglibProxyClass(Class<?> clazz) {
        return (clazz != null && isCglibProxyCLassName(clazz.getName()));
    }

    public static boolean isCglibProxyCLassName(String className) {
        return (className != null && className.contains("$$"));
    }
}
