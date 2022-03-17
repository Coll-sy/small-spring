package org.sy.springframework.test.cglib;

import net.sf.cglib.proxy.FixedValue;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/16
 * @Copyright： sunyangqaq@foxmail.com
 */
public class TargetResultFixed implements FixedValue {
    @Override
    public Object loadObject() throws Exception {
        System.out.println("锁定结果");
        Object obj = 999;
        return obj;
    }
}
