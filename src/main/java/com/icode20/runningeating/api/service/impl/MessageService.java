package com.icode20.runningeating.api.service.impl;

import com.icode20.runningeating.api.bean.Message;
import com.icode20.runningeating.api.mapper.mapperext.MessageMapper;
import com.icode20.runningeating.api.service.ServiceAdapter;
import com.icode20.runningeating.global.config.BaseResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class MessageService extends ServiceAdapter<Message, MessageMapper, BaseResponse> {
    @Resource
    MessageMapper mapper;

    @Override
    public String add(String TJson) {
        return super.add(TJson, Message.class).toJsonString();
    }

    @Override
    public String update(String Tjson) {
        return super.update(Tjson, Message.class).toJsonString();
    }

    @Override
    public MessageMapper attachMapper() {
        return mapper;
    }

    @Override
    public BaseResponse attachResponse() {
        return new BaseResponse();
    }
}
