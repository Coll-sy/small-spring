package bean.factory;

import org.sy.springframework.bean.BeansException;

/**
 * @description: beanFactory 抽象接口
 * @author: SunYang
 * @date: 2022/2/9
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface BeanFactory {
    /**
     * 获取Bean
     *
     * @param beanName bean name
     * @return Object
     * @throws BeansException bean异常
     */
    Object getBean(String beanName) throws BeansException;

    /**
     * 获取Bean
     *
     * @param beanName beanName
     * @param args     参数
     * @return Object
     * @throws BeansException bean异常
     */
    Object getBean(String beanName, Object... args) throws BeansException;
}
