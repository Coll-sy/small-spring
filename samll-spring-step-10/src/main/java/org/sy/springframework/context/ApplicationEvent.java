package org.sy.springframework.context;

import java.util.EventObject;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/12
 * @Copyright： sunyangqaq@foxmail.com
 */
public abstract class ApplicationEvent extends EventObject {

    /**
     *
     * @param source 最初发生事件的对象
     */
    public ApplicationEvent(Object source) {
        super(source);
    }

}
