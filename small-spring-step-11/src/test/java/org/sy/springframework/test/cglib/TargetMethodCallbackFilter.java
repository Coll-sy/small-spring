package org.sy.springframework.test.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/16
 * @Copyright： sunyangqaq@foxmail.com
 */
public class TargetMethodCallbackFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        if(method.getName().equals("method1")){
            System.out.println("filter method1 == 0");
            return 0;
        }
        if(method.getName().equals("method2")){
            System.out.println("filter method2 == 1");
            return 1;
        }
        if(method.getName().equals("method3")){
            System.out.println("filter method3 == 2");
            return 2;
        }
        // 没有判断的方法的默认索引
        return 0;
    }
}
