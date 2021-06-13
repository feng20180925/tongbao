package com.dongbao.ums.service.impl;

import com.dongbao.api.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.dongbao.api.ums.mapper.UmsMemberMapper;
import com.dongbao.common.util.BCryptPasswordEncoderUtils;
import com.dongbao.ums.service.UmsMemberService;
import com.dongbao.api.ums.entity.UmsMember;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public boolean register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO){
        UmsMember us=new UmsMember();
        BeanUtils.copyProperties(umsMemberRegisterParamDTO,us);
        us.setPassword(BCryptPasswordEncoderUtils.getEncode(us.getPassword()));
        System.out.println(us);

        return memberMapper.insert(us)==1?true:false;
    }

}
