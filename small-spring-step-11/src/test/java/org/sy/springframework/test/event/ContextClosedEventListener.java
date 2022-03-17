package org.sy.springframework.test.event;

import org.sy.springframework.context.ApplicationListener;
import org.sy.springframework.context.event.ContextClosedEvent;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/12
 * @Copyright： sunyangqaq@foxmail.com
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("容器关闭事件：" + this.getClass().getName());
    }
}
