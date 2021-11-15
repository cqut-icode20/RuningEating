package com.icode20.runningeating.api.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * comment
 * @author 
 */
@Data
public class Order implements Serializable {
    private String id;

    private String username;

    private Date time;

    private String goodId;

    private String content;

    private String userid;

    private Integer likes;

    private static final long serialVersionUID = 1L;
}