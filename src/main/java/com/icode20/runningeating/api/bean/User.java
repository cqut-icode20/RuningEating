package com.icode20.runningeating.api.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * comment
 *
 * @author
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Alias("User")
public class User{
    private Integer index;

    private String id;

    private String username;

    private String password;

    private String phoneNumber;

    private String email;

    private String addr;

    private String nickname;
}