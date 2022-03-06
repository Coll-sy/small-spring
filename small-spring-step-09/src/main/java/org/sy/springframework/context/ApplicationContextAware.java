package org.sy.springframework.context;

import org.sy.springframework.beans.BeansException;
import org.sy.springframework.beans.factory.Aware;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/3
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
