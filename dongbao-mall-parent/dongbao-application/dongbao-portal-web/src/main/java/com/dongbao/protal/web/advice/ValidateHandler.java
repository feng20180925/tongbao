package com.dongbao.protal.web.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @Description: 校验一场统一管理
 * @ClassName: ValidateHandler
 * @Author: xfeng
 * @Date: 2021/6/14 10:49
 * @Version: 1.0
 */

@ControllerAdvice
public class ValidateHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        System.out.println("进入了校验");

        StringBuilder sb=new StringBuilder();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            String defaultMessage = error.getDefaultMessage();

            System.out.println("defaultMessage="+defaultMessage+"code="+error.getCode());
            sb.append("  "+defaultMessage);

            break;
        }


        return new ResponseEntity(sb, HttpStatus.OK);
    }
}
