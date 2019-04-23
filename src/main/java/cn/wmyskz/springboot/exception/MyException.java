package cn.wmyskz.springboot.exception;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2018年12月28日 20:29
 */
public class MyException extends RuntimeException{
    public MyException(String message){
        super(message);
    }
}
