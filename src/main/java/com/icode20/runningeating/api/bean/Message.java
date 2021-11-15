package com.icode20.runningeating.api.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * comment
 * @author 
 */
@Data
public class Message implements Serializable {
    private String id;

    private String username;

    private Date time;

    private String goodId;

    private String content;

    private String userId;

    private Integer likes;

}