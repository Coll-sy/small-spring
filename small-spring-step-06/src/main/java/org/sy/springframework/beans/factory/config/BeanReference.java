package org.sy.springframework.beans.factory.config;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/11
 * @Copyright： sunyangqaq@foxmail.com
 */
public class BeanReference {

    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
