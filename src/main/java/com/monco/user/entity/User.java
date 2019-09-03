package com.monco.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.monco.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author monco
 * @since 2019-09-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user")
@ApiModel(value="User对象", description="")
public class User extends BaseEntity<User> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "乐观锁")
    @Version
    private Long version;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "生日")
    private Date birthday;

    @ApiModelProperty(value = "血型")
    private String blood;

    @ApiModelProperty(value = "教育经历")
    private String education;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "身份证号")
    private String identityCode;

    @ApiModelProperty(value = "工作")
    private String job;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "手机号")
    private String phoneCode;

    @ApiModelProperty(value = "图片")
    private String pic;

    @ApiModelProperty(value = "姓名")
    private String realName;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "个性签名")
    private String signature;

    @ApiModelProperty(value = "用户类型")
    private Integer userType;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "微信号")
    private String weChatCode;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
