package org.sy.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/12
 * @Copyright： sunyangqaq@foxmail.com
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "sunyang");
        hashMap.put("10002", "zhangsan");
        hashMap.put("10003", "三毛");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
