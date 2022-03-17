package org.sy.springframework.test.cglib;

import net.sf.cglib.proxy.Dispatcher;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/17
 * @Copyright： sunyangqaq@foxmail.com
 */
public class ConcreteClassDispatcher implements Dispatcher {
    @Override
    public Object loadObject() throws Exception {
        System.out.println("before Dispatcher");
        PropertyBean propertyBean = new PropertyBean();
        propertyBean.setKey("xxx");
        propertyBean.setValue(new TargetObject());
        System.out.println("after Dispatcher");
        return propertyBean;
    }
}
