package org.sy.springframework.beans;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/11
 * @Copyright： sunyangqaq@foxmail.com
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
