package com.icode20.runningeating.global.service.impl;

import com.icode20.runningeating.api.bean.User;
import com.icode20.runningeating.global.config.BaseResponse;
import com.icode20.runningeating.global.config.GlobalResponse;
import com.icode20.runningeating.global.mapper.GlobalMapper;
import com.icode20.runningeating.global.service.GlobalService;
import com.icode20.runningeating.global.util.AppContext;
import com.icode20.runningeating.global.util.CacheManger;
import com.icode20.runningeating.global.util.QQEMail;
import com.icode20.runningeating.global.util.Util;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 * @author lixin
 * description
 * @date 2021/10/29 20:36
 */
@Service
public class GlobalServiceImpl implements GlobalService {
    static Logger logger = Logger.getLogger(GlobalServiceImpl.class);
    @Resource
    GlobalMapper mapper;

    @Override
    public String login(String userName, String password) {
        GlobalResponse.GlobalResponseBuilder builder = GlobalResponse.builder();
        //如果参数为空
        if (Util.isParamsNull(userName, password)) {
            return builder.message(GlobalResponse.LOGIN_MESSAGE_FAILED).status(GlobalResponse.RESPONSE_CODE_FAILED).build().toJsonString();
        }
        User user = mapper.findUserByName(userName);
        if ((userName != null ? userName.length() : 0) == 0 || user == null) {
            builder.message(GlobalResponse.LOGIN_MESSAGE_NONE_USER).
                    status(BaseResponse.RESPONSE_CODE_FAILED);
        } else if (password.length() == 0 || !user.getPassword().equals(password)) {
            builder.message(GlobalResponse.LOGIN_MESSAGE_ERROR_PASSWORD)
                    .status(GlobalResponse.RESPONSE_CODE_FAILED);
        } else {
            builder.message(GlobalResponse.LOGIN_MESSAGE_SUCCESS)
                    .status(GlobalResponse.RESPONSE_CODE_SUCCESS)
                    .token(user.getId());
        }
        return builder.build().toJsonString();
    }

    @Override
    public String register(String userName, String password, String emil, String cheekCode, HttpServletRequest request) {
        GlobalResponse.GlobalResponseBuilder builder = GlobalResponse.builder();
        //如果参数为空
        if (Util.isParamsNull(userName, password, cheekCode, emil)) {
            builder.message(GlobalResponse.REGISTER_MESSAGE_FAILED)
                    .status(GlobalResponse.RESPONSE_CODE_FAILED);
            return builder.build().toJsonString();
        }
        String token = "";
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return builder.message(GlobalResponse.REGISTER_MESSAGE_FAILED).build().toJsonString();
        }
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())) {
                //时间戳
                token = cookie.getValue();
            }
        }
        //通过token拿到对应的那个验证码
        String code = CacheManger.getCodeCache(token);
        //没有过期时
        if (!Util.isParamsNull(code)) {
            //如果本地保存的和传过来的相等 执行注册
            if (code.equals(cheekCode)) {
                GlobalResponse register = register(userName, password, emil);
                CacheManger.remove(token);
                return register.toJsonString();
            } else {
                return builder.message(GlobalResponse.REGISTER_MESSAGE_EMIL_CODE_FAILED).build().toJsonString();
            }
        } else {
            //验证码过期
            builder.status(GlobalResponse.RESPONSE_CODE_FAILED).
                    message(GlobalResponse.REGISTER_MESSAGE_EMIL_CODE_NO_INVALID);
            return builder.build().toJsonString();
        }
    }

    private GlobalResponse register(String userName, String password, String emil) {
        GlobalResponse.GlobalResponseBuilder builder = GlobalResponse.builder();
        //先查询数据库里面有没有数据
        User user = mapper.findUserByName(userName);
        //有数据返回失败
        if (user != null) {
            builder.message(GlobalResponse.REGISTER_MESSAGE_USER_EXCITES)
                    .status(GlobalResponse.RESPONSE_CODE_SUCCESS);
            return builder.build();
        }
        //开始插入数据
        boolean isSuccess = (mapper.insertUser(userName, password, emil) == 1);
        //查询刚刚加入的数据是否成功
        User createdUser = mapper.findUserByName(userName);
        //如果成功了
        if (isSuccess && createdUser != null) {
            builder.message(GlobalResponse.REGISTER_MESSAGE_SUCCESS)
                    .token(createdUser.getId())
                    .status(GlobalResponse.RESPONSE_CODE_SUCCESS);
        } else {
            builder.message(GlobalResponse.REGISTER_MESSAGE_FAILED)
                    .status(GlobalResponse.RESPONSE_CODE_FAILED);
        }
        return builder.build();
    }

    @Override
    public String sendEmail(String email, HttpServletResponse response) {
        logger.debug(email);
        GlobalResponse.GlobalResponseBuilder builder = GlobalResponse.builder();
        builder.status(GlobalResponse.RESPONSE_CODE_FAILED);
        //获取app基本信息
        Properties properties = AppContext.appInfo();
        //生成随机验证码
        String invalidationCode = Util.createInvalidationCode();
        //发送邮件
        if (!Util.isParamsNull(email)) {
            try {
                QQEMail.send(properties.getProperty("app.name.chinese"), invalidationCode, email);
            } catch (Exception e) {
                //邮件发送失败
                logger.error(e.getMessage() + e.getStackTrace()[0]);
                e.printStackTrace();
                builder.message(GlobalResponse.REGISTER_MESSAGE_EMIL_SEND_FAILED);
                return builder.build().toJsonString();
            }
            //生成token 时间戳
            String token = String.valueOf(System.currentTimeMillis());
            //缓存该token对应的验证码
            CacheManger.putCodeCache(token, invalidationCode);
            //token保存在cookies里面
            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge((int) CacheManger.TIME_OUT);
            cookie.setPath("/");
            //把cookie响应给客户端
            response.addCookie(cookie);
            //此时没有注册所有客户端没有token （id）
            builder.message(GlobalResponse.REGISTER_MESSAGE_EMIL_SEND_SUCCESS);
            return builder.build().toJsonString();
        }
        builder.status(GlobalResponse.RESPONSE_CODE_FAILED)
                .message(GlobalResponse.REGISTER_MESSAGE_EMIL_SEND_FAILED);
        return builder.build().toJsonString();
    }
}
