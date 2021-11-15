package com.icode20.runningeating.api.service;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author LIXIN
 * @description
 * @date 2021/11/13 18:42
 */
@Component
public interface BaseService {
    Logger logger = Logger.getLogger(BaseService.class);

    /**
     * @return 获取所有的<T>列表
     * @apiNote 可以一次性加载完毕缓存到客户端
     */
    String getAll();

    /**
     * @param startIndex 其实索引 可选参数 默认0
     * @param endIndex   结束索引 可选参数 默认20
     * @return 返回区间<T>  如果没有参数就返回 startIndex---startIndex+20
     * @apiNote 可以实现分页查询
     */
    String getLimit(Integer startIndex, Integer endIndex);


    /**
     * @param id <T>id
     * @return 返回该id的<T>
     * @apiNote 可以实现诸如<T>详情，订单包含<T>等等
     */
    String searchById(String id);

    /**
     * @param TJson 要添加的<T>json json字符串必需要是数组[{},{}]
     * @return 是否添加成功
     */
    String add(String TJson);

    /***
     * @param id 要删除 <T>的id
     * @return 返回是否删除成功
     */
    String delete(String id);

    /***
     * @param Tjson 要更新的
     * @return 更新是否成功
     */
    String update(String Tjson);

    /**
     * @return 返回总条数
     */
    String count();

    /**
     * @param bluer 关键词
     * @return 返回包含关键词的<T>条数
     * 默认实现
     */
    String bluerCount(String bluer);

    /**
     * @param bluer      关键词语
     * @param startIndex 起始索引
     * @param endIndex   结束索引
     * @return 返回和关键词相关的T
     * @apiNote 可以实现模糊查询和搜索功能
     */
    String searchByKeys(String bluer, Integer startIndex, Integer endIndex);
}
