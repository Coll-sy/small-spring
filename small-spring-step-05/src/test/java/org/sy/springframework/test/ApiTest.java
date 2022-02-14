package org.sy.springframework.test;

import cn.hutool.core.io.IoUtil;
import org.junit.Before;
import org.junit.Test;
import org.sy.springframework.beans.factory.PropertyValue;
import org.sy.springframework.beans.factory.PropertyValues;
import org.sy.springframework.beans.factory.config.BeanDefinition;
import org.sy.springframework.beans.factory.config.BeanReference;
import org.sy.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.sy.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.sy.springframework.core.io.DefaultResourceLoader;
import org.sy.springframework.core.io.Resource;
import org.sy.springframework.test.bean.UserDao;
import org.sy.springframework.test.bean.UserService;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/10
 * @Copyright： sunyangqaq@foxmail.com
 */
public class ApiTest {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:spring.xml");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException{
        Resource resource = resourceLoader.getResource("https://www.w3school.com.cn/example/xmle/note.xml");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void text_xml() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println(result);
    }
}
