package org.sy.springframework.context.event;

import org.sy.springframework.context.ApplicationEvent;
import org.sy.springframework.context.ApplicationListener;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/12
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface ApplicationEventMulticaster {

    /**
     * 添加一个listener，获取通知当事件发生时
     * @param listener 监听者
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * 移除一个listener
     * @param listener 监听者
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * 多播事件
     * @param event 事件
     */
    void multicastEvent(ApplicationEvent event);
}
