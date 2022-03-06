package org.sy.springframework.test.bean;

import org.sy.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/6
 * @Copyright： sunyangqaq@foxmail.com
 */
public class ProxyBeanFactory implements FactoryBean<IUserDao> {
    @Override
    public IUserDao getObject() throws Exception {
        InvocationHandler handler = ((proxy, method, args) -> {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("10001", "xiaofuge");
            hashMap.put("10002", "xiaosun");
            hashMap.put("10003", "阿毛");
            return "你被代理了 " + method.getName() + ":" + hashMap.get(args[0].toString());
        });
        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
