package org.sy.springframework.context;

import org.sy.springframework.context.ApplicationEvent;

import java.util.EventListener;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/12
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);
}
