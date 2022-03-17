package org.sy.springframework.test.cglib;

import net.sf.cglib.proxy.*;
import org.junit.Test;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/16
 * @Copyright： sunyangqaq@foxmail.com
 */
public class CgLibDemo {

    @Test
    public void test_targetInvoke() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        enhancer.setCallback(new TargetInterceptor());
        TargetObject targetObject2 = (TargetObject) enhancer.create();
        System.out.println(targetObject2);
        System.out.println(targetObject2.method1("mmmm1"));
        System.out.println(targetObject2.method2(100));
        System.out.println(targetObject2.method3(200));
    }

    @Test
    public void test_callbackFilter() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        CallbackFilter callbackFilter = new TargetMethodCallbackFilter();
        Callback noopCb = NoOp.INSTANCE;
        Callback callback1 = new TargetInterceptor();
        Callback fixedValue=new TargetResultFixed();
        Callback[] cbarray = new Callback[] {callback1, noopCb, fixedValue};
        enhancer.setCallbacks(cbarray);
        enhancer.setCallbackFilter(callbackFilter);
        TargetObject targetObject2 = (TargetObject) enhancer.create();
        System.out.println(targetObject2);
        System.out.println(targetObject2.method1("mmm1"));
        System.out.println(targetObject2.method2(100));
        System.out.println(targetObject2.method3(100));
        System.out.println(targetObject2.method3(100));
    }

    @Test
    public void test_InterfaceMaker() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InterfaceMaker interfaceMaker = new InterfaceMaker();
        interfaceMaker.add(TargetObject.class);
        Class<?> targetInterface = interfaceMaker.create();
        for (Method method : targetInterface.getMethods()) {
            System.out.println(method.getName());
        }
        Object object = Enhancer.create(Object.class, new Class[]{targetInterface}, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equals("method1")) {
                    System.out.println("filter method1");
                    return "sssssssss";
                }
                if (method.getName().equals("method2")) {
                    System.out.println("filter method2");
                    return 111111;
                }
                if (method.getName().equals("method3")) {
                    System.out.println("filter method3");
                    return 123123;
                }
                return "default";
            }
        });
        Method targetMethod1 = object.getClass().getMethod("method3", new Class[]{int.class});
        int i = (int) targetMethod1.invoke(object, new Object[]{33});
        Method targetMethod = object.getClass().getMethod("method1", new Class[]{String.class});
        System.out.println(targetMethod.invoke(object, new Object[]{"add"}));
    }
}
