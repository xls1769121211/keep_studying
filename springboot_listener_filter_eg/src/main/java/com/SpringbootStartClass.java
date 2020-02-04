package com;

import com.xls.test1.controller.HelloWorld;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot 启动类，
 * 默认扫描所在包 下面的所有注解
 * @SpringBootApplication 标识是spring boot的启动类
 */

@SpringBootApplication

public class SpringbootStartClass{
    public static void main(String[] args) {
        SpringApplication.run(HelloWorld.class, args);
    }
}
