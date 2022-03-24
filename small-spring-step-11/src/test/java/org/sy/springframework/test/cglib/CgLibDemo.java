package org.sy.springframework.test.cglib;

import net.sf.cglib.proxy.*;
import org.junit.Test;
import org.sy.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.sy.springframework.test.bean.IUserService;
import org.sy.springframework.test.bean.UserService;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
    public void test_interfaceMaker() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
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

    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* org.sy.springframework.test.bean.UserService.*(..))");
        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
    }

    @Test
    public void test_proxy_class() {
        IUserService iUserService = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[] {IUserService.class}, (proxy, method, args) ->  "你被代理了" );
        String result = iUserService.queryUserInfo();
        System.out.println(result);
    }

    @Test
    public void test_proxy_method() {
        Object targetObj = new UserService();

        IUserService proxy = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


                return null;
            }
        });
    }
}
