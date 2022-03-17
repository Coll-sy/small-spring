package org.sy.springframework.test.event;

import org.sy.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/12
 * @Copyright： sunyangqaq@foxmail.com
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到: " + event.getSource() + "消息;时间: " + new Date());
        System.out.println("消息: " + event.getId() + ":" + event.getMessage());
    }
}
