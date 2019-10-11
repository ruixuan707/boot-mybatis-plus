package com.monco.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author monco
 * @since 2019-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Authority对象", description="权限表")
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "上级ID")
    private Long parentId;

    @ApiModelProperty(value = "名称")
    private String authorityName;

    @ApiModelProperty(value = "编码")
    private String authorityCode;

    @ApiModelProperty(value = "类型")
    private String authorityType;

    @ApiModelProperty(value = "菜单路径")
    private String menuPath;

    @ApiModelProperty(value = "排序")
    private Integer sort;


}
