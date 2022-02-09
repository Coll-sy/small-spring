package org.sy.springframework.beans;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/9
 * @Copyright： sunyangqaq@foxmail.com
 */
public class BeansException extends Exception{
    public BeansException(String message, Exception e) {
        super(message, e);
    }
}
