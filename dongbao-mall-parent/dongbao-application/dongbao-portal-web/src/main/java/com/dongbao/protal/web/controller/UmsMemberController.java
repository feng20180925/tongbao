package com.dongbao.protal.web.controller;


import com.dongbao.api.ums.entity.UmsMember;
import com.dongbao.api.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author xfeng
 * @since 2021-06-12
 */
@RestController
@RequestMapping("/ums-member")
public class UmsMemberController {

    @Autowired
    UmsMemberService service;


    @GetMapping("/hello")
    public String getHello(){
        System.out.println("访问了hello");
        return "hello";

    }

    @PostMapping("/register")
    public String getRegister(@RequestBody UmsMemberRegisterParamDTO umsMemberRegisterParamDTO){
        System.out.println(umsMemberRegisterParamDTO);
        boolean flag = service.register(umsMemberRegisterParamDTO);
        if(flag){
            return "注册成功";
        }
        return "注册失败";
    }

}

