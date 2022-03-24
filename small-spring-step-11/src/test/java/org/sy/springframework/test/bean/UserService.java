package org.sy.springframework.test.bean;

import org.sy.springframework.beans.BeansException;
import org.sy.springframework.beans.factory.*;
import org.sy.springframework.context.ApplicationContext;
import org.sy.springframework.context.ApplicationContextAware;

import java.util.Random;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public class UserService implements IUserService{

    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sunyang, 100001, shenzheng";
    }

    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "register username: " + userName + " success! ";

    }

}
