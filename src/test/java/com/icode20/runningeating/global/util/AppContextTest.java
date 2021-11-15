package com.icode20.runningeating.global.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppContextTest {

    @Test
    void testAppInfo() {
        String property = AppContext.appInfo().getProperty("app.name.english");
        System.out.println(property);
    }
}