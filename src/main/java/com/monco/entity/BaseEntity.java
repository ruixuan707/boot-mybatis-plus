package com.monco.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Auther: monco
 * @Date: 2019/8/26 11:35
 * @Description:
 */
@Data
@ApiModel(value = "基类对象", description = "基类")
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 5175950932374337809L;

    @TableId(value = "id",type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Long id;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "状态")
    private String status;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人")
    private Long createId;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改人")
    private Long updateId;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改时间")
    private Date updateDate;

    @TableLogic
    @ApiModelProperty(value = "删除标志位")
    private Integer deleted;
}
