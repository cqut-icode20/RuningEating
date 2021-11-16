package com.icode20.runningeating.api.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Message {
    private String id;

    private String userId;

    private Boolean messageType;

    private String title;

    private String imagePath;

    private String sendTo;

    private String content;

    private String from;

    private Date date;

}