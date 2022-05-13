package cn.irisicm.exception;

/**
 * @author hmhu6
 */
public class MyException extends RuntimeException {

    /**
     * 异常构造方法 在使用时方便传入错误码和信息
     */
    public MyException(String msg) {
        super(msg);
    }

}

