package com.dongbao.common.base.result;

import com.dongbao.common.base.enums.StateCodeEnum;
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

    /**
     * 返回成功的包装
     * @return
     */
    public static ResultWrapper.ResultWrapperBuilder getSuccessBuildre(){
        return ResultWrapper.builder().code(StateCodeEnum.SUCCESS.getCode()).msg(StateCodeEnum.SUCCESS.getMsg());
    }


    /**
     * 返回失败的包装
     * @return
     */
    public static ResultWrapper.ResultWrapperBuilder getFailBuildre(){
        return ResultWrapper.builder().code(StateCodeEnum.FAIL.getCode()).msg(StateCodeEnum.FAIL.getMsg());
    }
}
