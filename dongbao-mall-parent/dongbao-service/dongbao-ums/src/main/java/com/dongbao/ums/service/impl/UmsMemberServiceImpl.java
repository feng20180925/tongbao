package com.dongbao.ums.service.impl;

import com.dongbao.api.ums.entity.dto.UmsMemberLoginParamDTO;
import com.dongbao.api.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.dongbao.api.ums.mapper.UmsMemberMapper;
import com.dongbao.common.base.result.ResultWrapper;
import com.dongbao.common.util.BCryptPasswordEncoderUtils;
import com.dongbao.ums.service.UmsMemberService;
import com.dongbao.api.ums.entity.UmsMember;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author xfeng
 * @since 2021-06-12
 */
@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService {

    @Autowired
    UmsMemberMapper memberMapper;


    @Transactional
    @Override
    public ResultWrapper register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO){
        UmsMember us=new UmsMember();
        BeanUtils.copyProperties(umsMemberRegisterParamDTO,us);
        us.setPassword(BCryptPasswordEncoderUtils.getEncode(us.getPassword()));

        boolean flag=memberMapper.insert(us)==1?true:false;
        if(flag){
            return ResultWrapper.getSuccessBuildre().data("注册成功").build();
        }
        return ResultWrapper.getFailBuildre().data("注册失败").build();
    }


    @Override
    public UmsMemberLoginParamDTO doLogin(UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
        String username = umsMemberLoginParamDTO.getUsername();
        if(StringUtils.isEmpty(username)){
            return null;
        }
        UmsMember us=memberMapper.selectByUsername(username);
        if(BCryptPasswordEncoderUtils.getMatch(umsMemberLoginParamDTO.getPassword(),us.getPassword())){
            //密码验证通过
            BeanUtils.copyProperties(us,umsMemberLoginParamDTO);
            return umsMemberLoginParamDTO;
        }
        return null;
    }

}
