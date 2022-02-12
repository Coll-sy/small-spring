package org.sy.springframework.bean.factory.config;

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

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
