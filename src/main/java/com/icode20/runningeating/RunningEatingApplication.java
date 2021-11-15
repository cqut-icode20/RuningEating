package com.icode20.runningeating;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/**
 * description
 *
 * @date 2021/10/29 20:39
 */
@SpringBootApplication
public class RunningEatingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(RunningEatingApplication.class, args);
    }
}

