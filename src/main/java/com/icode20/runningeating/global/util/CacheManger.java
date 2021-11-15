package com.icode20.runningeating.global.util;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *@author LIXIN
 *@description 缓存管理
 *@date 2021/11/13 22:04
 */
public class CacheManger {
    //缓存超时 3分钟过期
    public static final long TIME_OUT = 1000 * 60 * 3;
    private static final Cache<String, String> CODE_CACHE = CacheUtil.newTimedCache(TIME_OUT);
    static Logger logger = LoggerFactory.getLogger(CacheManger.class);

    public static void putCodeCache(String key, String value) {
        if (!CODE_CACHE.containsKey(key)) {
            CODE_CACHE.put(key, value);
        } else {
            logger.error(key + ":在缓存队列里面已经存在");
        }
    }

    public static String getCodeCache(String key) {
        return CODE_CACHE.get(key);
    }

    public static void remove(String key) {
        if (CODE_CACHE.containsKey(key)) {
            CODE_CACHE.remove(key);
        }
    }
}
