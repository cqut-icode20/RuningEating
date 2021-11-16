package com.icode20.runningeating.api.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * comment
 *
 * @author
 */
@Data
@NoArgsConstructor
public class Order implements Serializable {
    private String id;

    private String orderCode;

    private Integer count;

    private Date orderTime;

    private Integer state;

    private Integer transportFee;

    private String userId;

    private String goodId;

    private Good good;

    private String info;
}