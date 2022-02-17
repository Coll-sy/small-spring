package org.sy.springframework.beans;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/9
 * @Copyright： sunyangqaq@foxmail.com
 */
public class BeansException extends RuntimeException{

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BeansException(String msg) {
        super(msg);
    }
}
