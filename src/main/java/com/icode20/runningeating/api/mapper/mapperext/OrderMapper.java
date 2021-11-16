package com.icode20.runningeating.api.mapper.mapperext;

import com.icode20.runningeating.api.bean.Order;
import com.icode20.runningeating.api.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    List<Order> getAll();

    List<Order> getLimit(int startIndex, int limit);


    List<Order> searchByKeys(String bluer, int startIndex, int limit);

    Order searchById(String id);

    boolean add(Order Order);

    boolean delete(String id);

    boolean update(Order Order);

    int count();

    int bluerCount(String bluer);
}
