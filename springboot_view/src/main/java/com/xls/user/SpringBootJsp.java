package com.xls.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot 整合jsp
 *      在 application.properties 中配置视图解析器
 * spring boot 整合freemarker
 *      在 resources/templates 创建 .ftl 模板文件
 * spring boot 整合jsp
 *
 */
@SpringBootApplication

public class SpringBootJsp{
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJsp.class,args);
    }
}
