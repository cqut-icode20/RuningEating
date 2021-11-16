package com.icode20.runningeating.global.config;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author LIXIN
 * @description 响应基类
 * @date 2021/11/12 16:48
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {

    public static final int RESPONSE_CODE_SUCCESS = 200;
    public static final int RESPONSE_CODE_FAILED = 400;
    public static String OPERATION_ADD = "添加";
    public static String OPERATION_DELETE = "删除";
    public static String OPERATION_FIND = "查询";
    public static String OPERATION_UPDATE = "更新";
    /**
     * 响应体
     */
    public Object body;
    /**
     * 响应信息
     */
    public String message;
    /**
     * 状态码 200失败 400成功
     */
    public Object status;
    /**
     * 操作
     */
    public String operation;
    /**
     * 命名空间 对具体那个对象进行的事务
     */
    public String namespace;

    public String getNamespace() {
        return this.getClass().getSimpleName();
    }

    public String toJsonString() {
        /*
          处理一下status 当是true时转换为成功
         */
        if (status == null) {
            status = RESPONSE_CODE_SUCCESS;
        } else if (status instanceof Boolean) {
            if (!(Boolean) status) {
                status = RESPONSE_CODE_FAILED;
            } else {
                status = RESPONSE_CODE_SUCCESS;
            }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("info", this);
        return jsonObject.toJSONString();
    }

}
