package com.icode20.runningeating.api.service.impl;

import com.icode20.runningeating.api.bean.Good;
import com.icode20.runningeating.api.mapper.mapperext.GoodMapper;
import com.icode20.runningeating.api.response.GoodResponse;
import com.icode20.runningeating.api.service.ServiceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodService extends ServiceAdapter<Good, GoodMapper, GoodResponse> {

    @Autowired
    private GoodMapper mapper;

    @Override
    public GoodMapper attachMapper() {
        return mapper;
    }

    @Override
    public GoodResponse attachResponse() {
        return new GoodResponse();
    }

    @Override
    public String add(String TJson) {
        return super.add(TJson, Good.class).toJsonString();
    }


    @Override
    public String update(String Tjson) {
        return super.update(Tjson, Good.class).toJsonString();
    }


}
