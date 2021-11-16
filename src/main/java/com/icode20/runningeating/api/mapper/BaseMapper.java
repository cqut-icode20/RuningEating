package com.icode20.runningeating.api.mapper;

import java.util.List;

public interface BaseMapper<T> {
    /**
     * @return 获取所有的列表
     * @apiNote 可以一次性加载完毕缓存到客户端
     */
    List<T> getAll();

    /**
     * @param startIndex 其实索引
     * @param  limit  查询数量
     * @return 返回区间
     * @apiNote 可以实现分页查询
     */
    List<T> getLimit(int startIndex, int limit);

    /**
     * @param id bean id
     * @return 返回该id的bean
     * @apiNote 可以实现诸如用户详情，订单包含用户等等
     */
    T searchById(String id);

    /***
     * @param id 要删除 <T>的id
     * @return 返回是否删除成功
     */
    boolean delete(String id);

    /**
     * @param t 要更新的
     * @return 更新是否成功
     */
    boolean update(T t);


    /**
     * @return 返回总条数
     */
    int count();

    /**
     * @param bluer 模糊词语
     * @return 包含关键词的结果数量
     */
    int bluerCount(String bluer);

    /**
     * @param bluer      关键词搜索
     * @param startIndex 返回起始索引
     * @param limit   数量
     * @return 返回模糊查询区间结果  会比较多个字段
     */
    List<T> searchByKeys(String bluer, int startIndex, int limit);


    boolean add(T t);
}
