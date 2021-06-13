package com.dongbao.common.base.mapper;

import com.dongbao.api.ums.mapper.UmsMemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.dongbao.api.ums.entity.UmsMember;

/**
 * @Description: 测试类
 * @ClassName: UserMemberTest
 * @Author: xfeng
 * @Date: 2021/6/12 21:51
 * @Version: 1.0
 */

@SpringBootTest
public class UserMemberTest {

    @Autowired
    UmsMemberMapper memberMapper;

    @Test
    public void testInsert(){
        UmsMember us=new UmsMember();
        us.setUsername("xfeng");
        us.setStatus(0);
        memberMapper.insert(us);
    }


    @Test
    public int testUpdate(){
        UmsMember us=new UmsMember();
        us.setId(7L);
        return memberMapper.updateById(us);
    }
}
