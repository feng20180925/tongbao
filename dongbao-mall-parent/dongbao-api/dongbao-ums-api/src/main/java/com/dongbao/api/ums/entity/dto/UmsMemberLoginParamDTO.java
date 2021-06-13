package com.dongbao.api.ums.entity.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @Description: dto前台参数
 * @ClassName: UmsMemberRegisterParamDTO
 * @Author: xfeng
 * @Date: 2021/6/13 14:10
 * @Version: 1.0
 */

@Data
@ToString
public class UmsMemberLoginParamDTO {

    private String username;

    private String password;
    private String icon;
    private String email;
    private String nickName;

}
