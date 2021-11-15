package com.icode20.runningeating.api.controller;

import com.icode20.runningeating.api.service.BaseService;

public abstract class BaseController<S extends BaseService> {

    public abstract S attachService();


    /**
     * @return 获取所有的<T>列表
     * @apiNote 可以一次性加载完毕缓存到客户端
     */

    String getAll() {
        return attachService().getAll();
    }

    /**
     * @param startIndex 其实索引
     * @param endIndex   结束索引
     * @return 返回区间<T>
     * @apiNote 可以实现分页查询
     */
    String getLimit(int startIndex, int endIndex) {
        return attachService().getLimit(startIndex, endIndex);
    }

    /**
     * @param bluer 关键词语
     * @return 返回和关键词相关的T
     * @apiNote 可以实现模糊查询和搜索功能
     */
    String searchByKeys(String bluer, Integer startIndex, Integer endIndex) {
        return attachService().searchByKeys(bluer, startIndex, endIndex);
    }

    /**
     * @param id <T>id
     * @return 返回该id的<T>
     * @apiNote 可以实现诸如<T>详情，订单包含<T>等等
     */
    String searchById(String id) {
        return attachService().searchById(id);
    }

    /**
     * @param TJson 要添加的<T>json json字符串必需要是数组[{},{}]
     * @return 是否添加成功
     */
    String add(String TJson) {
        return attachService().add(TJson);
    }

    /***
     * @param id 要删除 <T>的id
     * @return 返回是否删除成功
     */
    String delete(String id) {
        return attachService().delete(id);
    }

    /***
     * @param Tjson 要更新的
     * @return 更新是否成功
     */
    String update(String Tjson) {
        return attachService().update(Tjson);
    }

    /**
     * @return 返回总条数
     */
    String count() {
        return attachService().count();
    }

    /**
     * @param bluer 关键词
     * @return 返回包含关键词的<T>条数
     */
    String bluerCount(String bluer) {
        return attachService().bluerCount(bluer);
    }
}
