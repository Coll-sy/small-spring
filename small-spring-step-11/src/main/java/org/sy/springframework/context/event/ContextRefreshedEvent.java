package org.sy.springframework.context.event;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/12
 * @Copyright： sunyangqaq@foxmail.com
 */
public class ContextRefreshedEvent extends ApplicationContextEvent{

    /**
     * @param source 最初发生事件的对象
     * @throws IllegalArgumentException if source is null
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
