package org.sy.springframework.util;

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
}
