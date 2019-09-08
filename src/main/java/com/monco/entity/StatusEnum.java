package com.monco.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @ClassName StatusEnum
 * @Description 状态枚举值
 * @Author monco
 * @Date 2019/8/27 0:11
 * @Version 1.0
 */
public enum StatusEnum {

    NORMAL(1, "正常"),
    UNUSUAL(2, "异常");

    StatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    @EnumValue
    private final int code;
    private final String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
