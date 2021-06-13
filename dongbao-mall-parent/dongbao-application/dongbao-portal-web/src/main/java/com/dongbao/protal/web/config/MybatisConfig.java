package com.dongbao.protal.web.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.dongbao.protal.web.controller.UmsMemberController;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description: mybatis中数据库更新字段默认值问题
 * @ClassName: MybatisConfig
 * @Author: xfeng
 * @Date: 2021/6/13 9:46
 * @Version: 1.0
 */

@Component
public class MybatisConfig implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("添加插入时间");
        this.setFieldValByName("gmtCreate",new Date(),metaObject);
        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("更新操作");
        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }
}
