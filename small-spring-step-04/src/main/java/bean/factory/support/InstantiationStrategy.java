package bean.factory.support;

import org.sy.springframework.bean.BeansException;
import org.sy.springframework.bean.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/10
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface InstantiationStrategy {

    /**
     * 实例化策略接口
     * @param beanDefinition bean定义对象
     * @param beanName beanName
     * @param ctor Constructor
     * @param args Constructor参数
     * @return Object
     * @throws BeansException Beans异常
     */
    Object instantiation(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) throws BeansException;

}
