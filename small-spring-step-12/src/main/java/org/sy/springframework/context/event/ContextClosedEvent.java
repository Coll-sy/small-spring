package org.sy.springframework.context.event;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/12
 * @Copyright： sunyangqaq@foxmail.com
 */
public class ContextClosedEvent extends ApplicationContextEvent{
    /**
     * @param source 最初发生事件的对象
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
