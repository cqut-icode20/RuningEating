package com.icode20.runningeating.global.util;

import org.junit.jupiter.api.Test;

import static com.icode20.runningeating.global.util.QQEMail.send;

class QQEMailTest {
    @Test
    public void testMail() {
        try {
            send("RunningEating","this is test","3389274991@qq.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}