package com.icode20.runningeating.api.service.impl;

import com.icode20.runningeating.api.bean.User;
import com.icode20.runningeating.api.mapper.mapperext.UserMapper;
import com.icode20.runningeating.api.response.UserResponse;
import com.icode20.runningeating.api.service.ServiceAdapter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService extends ServiceAdapter<User, UserMapper, UserResponse> {
    @Resource
    UserMapper mapper;

    @Override
    public UserMapper attachMapper() {
        return mapper;
    }

    @Override
    public UserResponse attachResponse() {
        return new UserResponse();
    }

    @Override
    public String add(String TJson) {
        UserResponse add = super.add(TJson, User.class);
        return add.toJsonString();
    }

    @Override
    public String update(String Tjson) {
        return super.update(Tjson, User.class).toJsonString();
    }
}
