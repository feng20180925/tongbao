package com.dongbao.common.base.enums;

import lombok.Data;

/**
 * @Description: 统一状态码
 * @ClassName: StateCodeEnum
 * @Author: xfeng
 * @Date: 2021/6/13 23:07
 * @Version: 1.0
 */

@Data
public class StateCodeEnum {

    //SUCCESS(200,"请求成功");

    private int code;
    private String msg;

    public StateCodeEnum(int code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
