package com.icode20.runningeating.api.mapper.mapperext;

import com.icode20.runningeating.api.bean.Good;
import com.icode20.runningeating.api.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface GoodMapper extends BaseMapper<Good> {
    /**
     * @return 获取所有的商品列表
     * @apiNote 可以一次性加载完毕缓存到客户端
     */
    List<Good> getAll();

    /**
     * @param startIndex 其实索引
     * @param limit   查询数量
     * @return 返回区间商品
     * @apiNote 可以实现分页查询
     */
    List<Good> getLimit(int startIndex, int limit);

    /**
     * @param bluer 关键词语
     * @return 返回和关键词相关的Good
     * @apiNote 可以实现模糊查询和搜索功能
     */
    List<Good> searchByKeys(String bluer, int startIndex, int limit);

    /**
     * @param id 商品id
     * @return 返回该id的商品
     * @apiNote 可以实现诸如商品详情，订单包含商品等等
     */
    Good searchById(String id);

    /**
     * @param good 要添加的商品
     * @return 是否添加成功
     */
    boolean add(Good good);

    /***
     * @param id 要删除 <T>的id
     * @return 返回是否删除成功
     */
    boolean delete(String id);

    /***
     * @param good 要更新的good
     * @return 更新是否成功
     */
    boolean update(Good good);


    /**
     * @return 返回总条数
     */
    int count();

    /**
     * @param bluer 关键词
     * @return 返回包含关键词的商品条数
     */
    int bluerCount(String bluer);
}
