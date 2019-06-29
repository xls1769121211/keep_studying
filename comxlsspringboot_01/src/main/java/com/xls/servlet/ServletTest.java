package com.xls.servlet;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * spring boot 整合Servlet方式一
 * 编写 启动类
 * 如果要扫描Servlet 需要加上@ServletComponentScan 注解
 */
@SpringBootApplication
@ServletComponentScan
public class ServletTest{
    public static void main(String[] args) {
        SpringApplication.run(ServletTest.class,args);
    }
}
