package org.sy.springframework.test.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/17
 * @Copyright： sunyangqaq@foxmail.com
 */
public class LazyBean {
    private String name;
    private int age;
    private PropertyBean propertyBean;
    private PropertyBean propertyBeanDispatcher;

    public LazyBean(String name, int age) {
        System.out.println("lazy bean init");
        this.name = name;
        this.age = age;
        this.propertyBean = createPropertyBean();
        this.propertyBeanDispatcher = createPropertyBeanDispatcher();
    }

    private PropertyBean createPropertyBean() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PropertyBean.class);
        PropertyBean pb = (PropertyBean) enhancer.create(PropertyBean.class, new ConcreteClassLazyLoader());
        return pb;
    }

    private PropertyBean createPropertyBeanDispatcher() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PropertyBean.class);
        PropertyBean pb = (PropertyBean) enhancer.create(PropertyBean.class, new ConcreteClassDispatcher());
        return pb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PropertyBean getPropertyBean() {
        return propertyBean;
    }

    public void setPropertyBean(PropertyBean propertyBean) {
        this.propertyBean = propertyBean;
    }

    public PropertyBean getPropertyBeanDispatcher() {
        return propertyBeanDispatcher;
    }

    public void setPropertyBeanDispatcher(PropertyBean propertyBeanDispatcher) {
        this.propertyBeanDispatcher = propertyBeanDispatcher;
    }

    @Override
    public String toString() {
        return "LazyBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", propertyBean=" + propertyBean +
                ", propertyBeanDispatcher=" + propertyBeanDispatcher +
                '}';
    }
}
