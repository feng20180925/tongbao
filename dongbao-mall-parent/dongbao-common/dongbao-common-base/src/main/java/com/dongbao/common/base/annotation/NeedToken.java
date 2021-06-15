package com.dongbao.common.base.annotation;

import java.lang.annotation.*;

/**
 * @Description: 自定义注解用来标识该注解需要有token
 * @ClassName: NeedToken
 * @Author: xfeng
 * @Date: 2021/6/15 20:47
 * @Version: 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NeedToken {

    boolean value() default true;
}
