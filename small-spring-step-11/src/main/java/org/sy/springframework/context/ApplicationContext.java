package org.sy.springframework.context;

import org.sy.springframework.beans.factory.HierarchicalBeanFactory;
import org.sy.springframework.beans.factory.ListableBeanFactory;
import org.sy.springframework.core.io.ResourceLoader;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/15
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {

}
