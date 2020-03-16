package com.rongyixuan.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.rongyixuan.demo.vo.Decorate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author chj
 * @since 2020-03-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_house")
public class House implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 省ID
     */
    private String province;

    /**
     * 市ID
     */
    private String city;

    /**
     * 区/县ID
     */
    private String district;

    /**
     * 小区名称
     */
    private String community;

    /**
     * 几室
     */
    private String room;

    /**
     * 几厅
     */
    private String hall;

    /**
     * 几卫
     */
    private String toilet;

    /**
     * 房屋朝向
     */
    private String orientation;

    /**
     * 枚举类
     * 装修类型
     */
    private Integer decorate;

    /**
     * 每月租金
     */
    private String rent;

    /**
     * 图片
     */
    private String pic;

    /**
     * 房屋介绍
     */
    private String introduction;


}
