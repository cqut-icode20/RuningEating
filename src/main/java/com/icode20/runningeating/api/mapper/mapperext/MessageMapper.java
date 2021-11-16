package com.icode20.runningeating.api.mapper.mapperext;

import com.icode20.runningeating.api.bean.Message;
import com.icode20.runningeating.api.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface MessageMapper extends BaseMapper<Message> {
    @Override
    List<Message> getAll();

    @Override
    List<Message> getLimit(int startIndex, int limit);

    @Override
    Message searchById(String id);

    @Override
    boolean delete(String id);

    @Override
    boolean update(Message message);

    @Override
    int count();

    @Override
    int bluerCount(String bluer);

    @Override
    List<Message> searchByKeys(String bluer, int startIndex, int limit);

    @Override
    boolean add(Message message);
}
