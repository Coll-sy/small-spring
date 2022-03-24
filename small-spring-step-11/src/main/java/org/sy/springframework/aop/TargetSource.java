package org.sy.springframework.aop;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/24
 * @Copyright： sunyangqaq@foxmail.com
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }
}
