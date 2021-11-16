package com.icode20.runningeating.api.service.impl;

import com.icode20.runningeating.api.bean.Order;
import com.icode20.runningeating.api.mapper.mapperext.OrderMapper;
import com.icode20.runningeating.api.response.OrderResponse;
import com.icode20.runningeating.api.service.ServiceAdapter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService extends ServiceAdapter<Order, OrderMapper, OrderResponse> {

    @Resource
    OrderMapper mapper;

    @Override
    public OrderMapper attachMapper() {
        return mapper;
    }

    @Override
    public OrderResponse attachResponse() {
        return new OrderResponse();
    }

    @Override
    public String searchById(String id) {
        return super.searchById(id);
    }

    @Override
    public String add(String TJson) {
        return super.add(TJson, Order.class).toJsonString();
    }

    @Override
    public String update(String Tjson) {
        return super.update(Tjson, Order.class).toJsonString();
    }


}
