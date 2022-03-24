package org.sy.springframework.test;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import org.sy.springframework.aop.AdvisedSupport;
import org.sy.springframework.aop.TargetSource;
import org.sy.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.sy.springframework.aop.framework.Cglib2AopProxy;
import org.sy.springframework.aop.framework.JdkDynamicAopProxy;
import org.sy.springframework.test.bean.IUserService;
import org.sy.springframework.test.bean.UserService;
import org.sy.springframework.test.bean.UserServiceInterceptor;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/10
 * @Copyright： sunyangqaq@foxmail.com
 */
public class ApiTest {
    @Test
    public void test_dynamic() {
        // 目标对象
        IUserService userService = new UserService();

        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* org.sy.springframework.test.bean.IUserService.*(..))"));

        // 代理对象(JdkDynamicAopProxy)
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        // 代理对象(Cglib2AopProxy)
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));
    }
}
