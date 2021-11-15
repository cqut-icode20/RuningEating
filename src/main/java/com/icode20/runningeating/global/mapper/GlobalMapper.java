package com.icode20.runningeating.global.mapper;

import com.icode20.runningeating.api.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author LIXIN
 * @description 用于登录验证
 * @date 2021/11/11 19:53
 */
@Mapper
public interface GlobalMapper {
    /**
     * @param name 用户名
     * @return 查询到的用户
     */
    User findUserByName(String name);

    /**
     * @param name     用户名
     * @param password 密码
     * @return 是否添加成功
     */
    int insertUser(String name, String password,String email);

}
