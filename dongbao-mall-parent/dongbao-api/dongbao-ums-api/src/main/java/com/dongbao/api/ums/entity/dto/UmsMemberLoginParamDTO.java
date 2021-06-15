package com.dongbao.api.ums.entity.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

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

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "用户名不能为空")
    private String password;
    private String icon;
    @Email(message = "邮件格式输入错误")
    private String email;
    private String nickName;

}
