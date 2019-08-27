package com.monco.entity;

/**
 * @ClassName FieldFill
 * @Description
 * @Author monco
 * @Date 2019/8/27 0:30
 * @Version 1.0
 */
public enum FieldFill {

    /**
     * 默认不处理
     */
    DEFAULT,
    /**
     * 插入填充字段
     */
    INSERT,
    /**
     * 更新填充字段
     */
    UPDATE,
    /**
     * 插入和更新填充字段
     */
    INSERT_UPDATE

}
