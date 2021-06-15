package com.dongbao.protal.web.controller;


import com.dongbao.api.ums.entity.UmsMember;
import com.dongbao.api.ums.entity.dto.UmsMemberLoginParamDTO;
import com.dongbao.api.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.dongbao.common.base.annotation.NeedToken;
import com.dongbao.common.base.result.ResultWrapper;
import com.dongbao.common.util.DongbaoCommonUtilApplication;
import com.dongbao.common.util.JwtUtils;
import com.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
//    @NeedToken(value = false)
    @NeedToken
    public ResultWrapper getHello(){
        System.out.println("访问了hello");
        return ResultWrapper.getSuccessBuildre().data("hello").build();

    }

    @PostMapping("/register")
    public ResultWrapper getRegister(@RequestBody @Valid UmsMemberRegisterParamDTO umsMemberRegisterParamDTO){

        return service.register(umsMemberRegisterParamDTO);

    }


    @PutMapping("/login")
    public ResultWrapper doLogin(@RequestBody @Valid UmsMemberLoginParamDTO umsMemberLoginParamDTO){
        UmsMemberLoginParamDTO loginParam = service.doLogin(umsMemberLoginParamDTO);

        DongbaoCommonUtilApplication a=new DongbaoCommonUtilApplication();

        if(loginParam!=null){
            String token = JwtUtils.geneJsonWebToken(loginParam.getUsername());
            return ResultWrapper.getSuccessBuildre().data(token).build();
        }
        return ResultWrapper.getFailBuildre().data("登录失败").build();
    }

}

