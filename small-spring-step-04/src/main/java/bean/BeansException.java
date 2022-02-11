package bean;

/**
 * @description:
 * @author: SunYang
 * @date: 2022/2/9
 * @Copyright： sunyangqaq@foxmail.com
 */
public class BeansException extends RuntimeException{
    public BeansException(String message, Throwable e) {
        super(message, e);
    }

    public BeansException(String message) {
        super(message);
    }
}
