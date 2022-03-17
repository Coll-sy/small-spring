package org.sy.springframework.test.cglib;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/3/17
 * @Copyright： sunyangqaq@foxmail.com
 */
public class PropertyBean {
    private String key;
    private Object value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PropertyBean{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
