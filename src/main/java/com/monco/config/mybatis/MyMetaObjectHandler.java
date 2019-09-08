package com.monco.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @ClassName MyMetaObjectHandler
 * @Description
 * @Author monco
 * @Date 2019/8/27 0:26
 * @Version 1.0
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("初始化添加数据");
        this.setFieldValByName("createId", Long.parseLong("1"), metaObject);
        this.setFieldValByName("createDate", new Date(), metaObject);
        this.setFieldValByName("updateId", Long.parseLong("1"), metaObject);
        this.setFieldValByName("updateDate", new Date(), metaObject);
        this.setFieldValByName("status", "启用", metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("初始化修改数据");
        this.setFieldValByName("updateId", Long.parseLong("2"), metaObject);
        this.setFieldValByName("updateDate", new Date(), metaObject);
    }
}
