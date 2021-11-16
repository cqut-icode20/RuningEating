package com.icode20.runningeating.api.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.icode20.runningeating.api.mapper.BaseMapper;
import com.icode20.runningeating.global.config.BaseResponse;
import com.icode20.runningeating.global.util.Util;
/*
  @author LIXIN
 * @description 服务适配器 过滤掉一些不需要实现的方法或者提供默认服务
 * @date 2021/11/15 11:12
 */

/**
 * @param <T> Bean类型
 * @param <M> Mapper
 * @param <R> Response
 */
public abstract class ServiceAdapter<T, M extends BaseMapper<T>, R extends BaseResponse> implements BaseService {


    //绑定mapper
    public abstract M attachMapper();

    //绑定响应器
    public abstract R attachResponse();

    @Override
    public String getAll() {
        R response = attachResponse();
        response.body = attachMapper().getAll();
        response.operation = BaseResponse.OPERATION_FIND;
        return response.toJsonString();
    }

    @Override
    public String getLimit(Integer startIndex, Integer endIndex) {
        if (startIndex == null) {
            startIndex = 0;
        }
        if (endIndex == null) {
            endIndex = startIndex + 20;
        }
        //计算offset和limit
        int limit = Math.abs(endIndex - startIndex);
        R response = attachResponse();
        response.body = attachMapper().getLimit(startIndex, limit);
        return response.toJsonString();
    }

    @Override
    public String searchById(String id) {
        R response = attachResponse();
        response.body = attachMapper().searchById(id);
        return response.toJsonString();
    }

    /***
     * @param TJson 要添加的类json
     * @param clazz 类对象 用于转换
     * @return 返回响应体
     */
    public R add(String TJson, Class<T> clazz) {
        R response = attachResponse();
        int counter = 0;
        JSONArray jsonArray;
        //如果是jsonArray
        if (!Util.isParamsNull(TJson)) {
            if (TJson.startsWith("[") && TJson.endsWith("]")) {
                jsonArray = JSONArray.parseArray(TJson);
            } else {
                JSONObject jsonObject = JSON.parseObject(TJson);
                jsonArray = new JSONArray();
                jsonArray.add(jsonObject);
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                T t = jsonObject.toJavaObject(clazz);
                if (attachMapper().add(t)) {
                    counter++;
                } else {
                    break;
                }
                builder.append(jsonObject.get("userId") == null ? jsonObject.getString("goodId") : jsonObject.get("userId")).append("\n");
            }
            response.body = builder.toString();
            response.message = counter + "个成功";
        } else {
            response.status = false;
            response.message = "body不能为空";
        }
        response.operation = BaseResponse.OPERATION_ADD;
        return response;
    }

    @Override
    public String delete(String id) {
        boolean delete = attachMapper().delete(id);
        R response = attachResponse();
        response.status = delete;
        response.body = id;
        response.operation = BaseResponse.OPERATION_DELETE;
        return response.toJsonString();
    }

    public R update(String Tjson, Class<T> clazz) {
        R response = attachResponse();
        if (!Util.isParamsNull(Tjson)) {
            JSONObject jsonObject = JSON.parseObject(Tjson);
            T t = jsonObject.toJavaObject(clazz);
            boolean update = attachMapper().update(t);
            response.message = jsonObject.getString("id");
            response.status = update;
        } else {
            response.status = false;
            response.message = "Body 不能为空";
        }
        response.operation = BaseResponse.OPERATION_UPDATE;
        return response;
    }

    @Override
    public String count() {
        int count = attachMapper().count();
        R response = attachResponse();
        response.body = count;
        response.operation = BaseResponse.OPERATION_FIND;
        return response.toJsonString();
    }

    @Override
    public String bluerCount(String bluer) {
        int i = attachMapper().bluerCount(bluer);
        R response = attachResponse();
        response.body = i;
        response.operation = BaseResponse.OPERATION_FIND;
        return response.toJsonString();
    }

    @Override
    public String searchByKeys(String bluer, Integer startIndex, Integer endIndex) {
        if (startIndex == null) {
            startIndex = 0;
        }
        if (endIndex == null) {
            endIndex = startIndex + 20;
        }
        int limit = Math.abs(endIndex - startIndex);
        R response = attachResponse();
        response.operation = BaseResponse.OPERATION_FIND;
        response.body = attachMapper().searchByKeys(bluer, startIndex, limit);
        return response.toJsonString();
    }
}
