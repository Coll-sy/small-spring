package org.sy.springframework.test.cglib;

import net.sf.cglib.proxy.LazyLoader;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/17
 * @Copyright： sunyangqaq@foxmail.com
 */
public class ConcreteClassLazyLoader implements LazyLoader {
    @Override
    public Object loadObject() throws Exception {
        System.out.println("before lazyLoader...");
        PropertyBean propertyBean = new PropertyBean();
        propertyBean.setKey("zghw");
        propertyBean.setValue(new TargetObject());
        System.out.println("after lazyLoader");
        return propertyBean;
    }
}
