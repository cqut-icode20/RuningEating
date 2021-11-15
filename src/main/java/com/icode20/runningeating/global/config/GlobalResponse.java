package com.icode20.runningeating.global.config;

import lombok.*;

/**
 * @author LIXIN
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class GlobalResponse extends BaseResponse {
    public static final String LOGIN_MESSAGE_NONE_USER = "没有该用户";
    public static final String LOGIN_MESSAGE_ERROR_PASSWORD = "密码错误";
    public static final String LOGIN_MESSAGE_SUCCESS = "登录成功";
    public static final String LOGIN_MESSAGE_FAILED = "登录失败";
    public static final String REGISTER_MESSAGE_SUCCESS = "注册成功";
    public static final String REGISTER_MESSAGE_USER_EXCITES = "用户已经存在";
    public static final String REGISTER_MESSAGE_FAILED = "注册失败";
    public static final String REGISTER_MESSAGE_EMIL_SEND_FAILED = "邮件发送失败，检查帐号";
    public static final String REGISTER_MESSAGE_EMIL_SEND_SUCCESS = "邮件发送成功";
    public static final String REGISTER_MESSAGE_EMIL_CODE_FAILED = "验证码错误";
    public static final String REGISTER_MESSAGE_EMIL_CODE_NO_INVALID = "验证码过期";
    /**
     * 登录验证
     */
    String token;

    /*
     * 生成包含父类字段的builder
     */
    @Builder()
    public GlobalResponse(Object body, String message, int status, String operation, String namespace, String token) {
        super(body, message, status, operation, namespace);
        this.token = token;
    }

    @Override
    public String getNamespace() {
        return "登录注册";
    }
}
