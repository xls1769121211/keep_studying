package com.xls;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xls.users.mapper") //开启mapper 扫描mapper文件
public class SpringBootStart{
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStart.class,args);
    }
}
