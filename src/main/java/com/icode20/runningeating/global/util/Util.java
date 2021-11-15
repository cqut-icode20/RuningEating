package com.icode20.runningeating.global.util;

import org.apache.logging.log4j.util.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Properties;

/**
 * @author LIXIN
 * @description
 * @date 2021/11/12 11:26
 */
public class Util {
    static Logger logger = LoggerFactory.getLogger(Util.class);

    /**
     * @param params 所有要判断的参数
     * @return 参数中是否有一个为空或者长度为0的字符串
     * 如果字符串长度为0会反回true
     */
    public static boolean isParamsNull(Object... params) {
        for (Object param : params) {
            if (param == null) {
                return true;
            } else if (param instanceof String) {
                if (((String) param).length() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param fileName 配置文件名
     * @return 返回该配置文件对象
     */
    public static Properties getProperties(String fileName) {
        Properties props = new Properties();
        try {
            props.load(new InputStreamReader(Objects.requireNonNull(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName))));
        } catch (IOException e) {
            logger.error(e.getMessage(), e.getStackTrace()[0]);
        }
        return props;
    }

    /***
     * @return 4位数字验证码
     */
    public static String createInvalidationCode() {
        char[] arr = String.valueOf(System.currentTimeMillis()).toCharArray();
        return arr[arr.length - 1] + "" + arr[arr.length - 3] + "" + arr[arr.length - 2] + "" + arr[arr.length - 4];
    }


}
