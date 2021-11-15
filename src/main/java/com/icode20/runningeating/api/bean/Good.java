package com.icode20.runningeating.api.bean;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


/**
 * @author LIXIN
 * @description
 * @date 2021/11/13 16:29
 */
@Data
@NoArgsConstructor
public class Good {
    //商品唯一标识
    private String id;
    //商品名字
    private String name;
    //商品价格
    private float price;
    //分类
    private int category;
    //上架时间
    private Date addTime;
    //商品描述
    private String description;
    //商品图标
    private String imageName;
    //销量
    private Integer sales;
    //库存
    private Integer stock;
}