package com.example.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 书实体类
 *
 * @author 张庆福
 * @date 2021-04-22 00:26:21
 */
@ApiModel("书")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("book")
public class Book implements Serializable {

    private static final long serialVersionUID = 883173734422228215L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 书名
     */
    @ApiModelProperty(value = "书名")
    private String name;

    /**
     * 删除标志:0=未删除,1=已删除
     */
    @ApiModelProperty(value = "删除标志:0=未删除,1=已删除")
    private Integer del;

}
