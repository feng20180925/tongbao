package com.dongbao.protal.web.advice;

import com.dongbao.common.base.result.ResultWrapper;
import com.dongbao.protal.web.exception.TokenException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 全局统一异常处理
 * @ClassName: GlobalExceptionHandle
 * @Author: xfeng
 * @Date: 2021/6/14 13:48
 * @Version: 1.0
 */

@ControllerAdvice
@RestController
public class GlobalExceptionHandle {

    @ExceptionHandler(Exception.class)
    public ResultWrapper customException(Exception ex){
        System.out.println(ex.getMessage());
        return ResultWrapper.builder().code(301).msg("统一异常").build();
    }

    @ExceptionHandler(TokenException.class)
    public ResultWrapper tokenException(Exception ex){
        System.out.println(ex.getMessage());
        return ResultWrapper.builder().code(502).msg("token错误异常").build();
    }
}
