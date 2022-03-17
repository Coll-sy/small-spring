package org.sy.springframework.test.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/16
 * @Copyright： sunyangqaq@foxmail.com
 */
public class TargetInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("\n调用前");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("方法名" + method.getName());
        System.out.println("调用后" + result);
        System.out.println();
        return result;
    }
}
