package com.icode20.runningeating.global.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LIXIN
 * @description
 * @date 2021/10/31 16:56
 */
public interface GlobalService {
    /**
     * @param userName 用户名
     * @param password 密码
     * @return 响应json
     */
    String login(String userName, String password);

    /**
     * @param userName 用户名
     * @param password 密码
     * @param request 获取请求信息
     * @param emil 注册邮箱
     * @return 返回注册响应json
     * note:
     */
    String register(String userName, String password, String emil,String cheekCode, HttpServletRequest request);

    /**
     * @param email 验证邮箱地址
     * @param request 请求
     * @return 返回响应json
     */
    String sendEmail(String email,HttpServletResponse request);
}
