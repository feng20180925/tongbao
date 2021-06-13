package com.dongbao.common.base.result;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 统一返回状态
 * @ClassName: ResultWrapper
 * @Author: xfeng
 * @Date: 2021/6/13 23:13
 * @Version: 1.0
 */

@Data
@Builder
public class ResultWrapper<T> implements Serializable {

    /**
     * 状态码
     */
    private int code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体数据
     */
    private T data;

    //返回成功的包装
    public static ResultWrapper.ResultWrapperBuilder getSuccessBuildre(){

        return null;
    }
}
