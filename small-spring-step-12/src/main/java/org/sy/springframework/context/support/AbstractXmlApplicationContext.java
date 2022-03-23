package org.sy.springframework.context.support;

import org.sy.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.sy.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/16
 * @Copyright： sunyangqaq@foxmail.com
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String[] configLocations =  getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
