package bean.factory.config;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/9
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例bean
     * @param beanName bean name
     * @return Object
     */
    Object getSingleton(String beanName);

}
