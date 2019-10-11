package com.monco.vo;

import com.monco.entity.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: monco
 * @Date: 2019/9/10 15:55
 * @Description:
 */
@Data
public class RoleVo extends Role {

    @ApiModelProperty(value = "权限ids")
    private Long[] authorityArrays;

}
