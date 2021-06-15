package com.dongbao.common.base.enums;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
* @Description: 统一状态码
 *      100-199：用户业务的
 *      200-299：支付业务
* @ClassName: StateCodeEnum
* @Author: xfeng
* @Date: 2021/6/13 23:07
* @Version: 1.0
 */

@Getter
public enum  StateCodeEnum {

    /**
     * 请求失败
     *
     */
    FAIL(500,"请求失败"),


    /**
     * 请求成功
     *
     */
    SUCCESS(200,"请求成功");

    private int code;
    private String msg;

    StateCodeEnum(int code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
