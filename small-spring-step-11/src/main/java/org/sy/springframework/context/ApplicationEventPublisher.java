package org.sy.springframework.context;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/12
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface ApplicationEventPublisher {
    /**
     * 通知所有监听者去注册一个应用事件
     * @param event
     */
    void publishEvent(ApplicationEvent event);
}
