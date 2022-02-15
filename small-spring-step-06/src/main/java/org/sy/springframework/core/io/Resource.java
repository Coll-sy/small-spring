package org.sy.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/14
 * @Copyright： sunyangqaq@foxmail.com
 */
public interface Resource {

    /**
     * 获取输入流
     * @return InputStream
     * @throws IOException IO异常
     */
    InputStream getInputStream() throws IOException;
}
