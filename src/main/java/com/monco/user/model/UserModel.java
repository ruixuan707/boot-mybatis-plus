package com.monco.user.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.monco.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author monco
 * @since 2019-08-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user")
@ApiModel(value="UserModel对象", description="用户表")
public class UserModel extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商户ID")
    private Long merchantId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "密钥")
    private String securityKey;

    @Version
    @ApiModelProperty(value = "乐观锁")
    private Long version;

}
