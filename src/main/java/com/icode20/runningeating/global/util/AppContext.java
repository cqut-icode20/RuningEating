package com.icode20.runningeating.global.util;

import java.util.Properties;

/**
 * @author LIXIN
 * @description 应用环境 提供一些应用相关的属性方法
 * @date 2021/11/12 20:29
 */
public class AppContext {
    /**
     * @return 当前应用信息
     * 应用名称 版本等 保存在global.properties配置文件里面
     */
    public static Properties appInfo() {
        return Util.getProperties("global.properties");
    }
}

