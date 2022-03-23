package org.sy.springframework.context.event;

import org.sy.springframework.context.ApplicationContext;
import org.sy.springframework.context.ApplicationEvent;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/12
 * @Copyright： sunyangqaq@foxmail.com
 */
public class ApplicationContextEvent extends ApplicationEvent {

    /**
     *
     * @param source 最初发生事件的对象
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplication() {
        return (ApplicationContext) getSource();
    }

}
