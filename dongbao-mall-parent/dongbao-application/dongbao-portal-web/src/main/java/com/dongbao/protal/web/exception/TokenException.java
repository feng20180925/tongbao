package com.dongbao.protal.web.exception;

/**
 * @Description: 自定义token错误异常
 * @ClassName: TokenException
 * @Author: xfeng
 * @Date: 2021/6/15 21:45
 * @Version: 1.0
 */

public class TokenException extends Exception{

    public TokenException() {
        super();
    }

    public TokenException(String message) {
        super(message);
    }
}
