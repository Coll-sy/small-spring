# 学习Spring源码 基础

1. BeanDefinition的定义： 一个bean的成员变量为该类的Class对象
2. BeanFactory接口定义：通过该beanName获取bean实例
3. SingletonBeanRegistry接口定义：获取单例
4. DefaultSingletonBeanRegistry  SingletonBeanRegistry接口的默认实现，一个Map实例存储对象
5. AbstractBeanFactory抽象模板类，抽象出需要提供给外面实现的方法，将流程定义出来
6. AbstractAutowireCapableBeanFactory  AbstractBeanFactory的部分实现，具有创建单例Bean的能力


![02类图](./asset/pic/BeanDefinition.png "BeanDefinition")