package org.sy.springframework.aop.framework;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.sy.springframework.aop.AdvisedSupport;
import org.sy.springframework.aop.AopProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/24
 * @Copyright： sunyangqaq@foxmail.com
 */
public class Cglib2AopProxy implements AopProxy {

    // 资源支持对象
    private final AdvisedSupport advised;

    public Cglib2AopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }


    @Override
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(advised.getTargetSource().getTarget().getClass());
        enhancer.setInterfaces(advised.getTargetSource().getTargetClass());
        enhancer.setCallback(new DynamicAdvisedInterceptor(advised));
        return enhancer.create();
    }

    private static class DynamicAdvisedInterceptor implements MethodInterceptor {

        private final AdvisedSupport advised;

        private DynamicAdvisedInterceptor(AdvisedSupport advised) {
            this.advised = advised;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            CglibMethodInvocation methodInvocation = new CglibMethodInvocation(advised.getTargetSource().getTarget(), method, objects, methodProxy);
            if (advised.getMethodMatcher().matches(method, advised.getTargetSource().getTarget().getClass())) {
                return advised.getMethodInterceptor().invoke(methodInvocation);
            }
            return methodInvocation.proceed();
        }

        private static class CglibMethodInvocation extends ReflectiveMethodInvocation{

            private final MethodProxy methodProxy;

            public CglibMethodInvocation(Object target, Method method, Object[] args, MethodProxy methodProxy) {
                super(target, method, args);
                this.methodProxy = methodProxy;
            }

            @Override
            public Object proceed() throws Throwable {
                return this.methodProxy.invoke(this.target, this.arguments);
            }
        }
    }
}
