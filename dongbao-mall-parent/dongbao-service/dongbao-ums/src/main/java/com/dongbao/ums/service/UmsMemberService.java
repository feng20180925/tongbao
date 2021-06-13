package com.dongbao.ums.service;

import com.dongbao.api.ums.entity.UmsMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dongbao.api.ums.entity.dto.UmsMemberLoginParamDTO;
import com.dongbao.api.ums.entity.dto.UmsMemberRegisterParamDTO;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author xfeng
 * @since 2021-06-12
 */
public interface UmsMemberService extends IService<UmsMember> {

    public boolean register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO);

    UmsMemberLoginParamDTO doLogin(UmsMemberLoginParamDTO umsMemberLoginParamDTO);
}
