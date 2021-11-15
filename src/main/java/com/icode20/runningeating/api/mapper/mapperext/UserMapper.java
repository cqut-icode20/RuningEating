package com.icode20.runningeating.api.mapper.mapperext;

import com.icode20.runningeating.api.bean.User;
import com.icode20.runningeating.api.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Override
    List<User> getLimit(int startIndex, int limit);

    @Override
    List<User> searchByKeys(String buler, int startIndex, int limit);

    @Override
    int bluerCount(String bluer);

    @Override
    List<User> getAll();

    @Override
    User searchById(String id);

    @Override
    boolean delete(String id);

    @Override
    boolean update(User User);

    @Override
    int count();


}
