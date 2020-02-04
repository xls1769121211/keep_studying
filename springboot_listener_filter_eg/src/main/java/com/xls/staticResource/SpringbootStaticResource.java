package com.xls.staticResource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot 访问静态资源
 * 方式一 ：classpath/static文件夹下的资源  文件夹名称必须是 static
 * 方式二 ：在ServletContext根目录下 src/main/webapp下 文件夹名称必须是webapp
 * */
@SpringBootApplication
public class SpringbootStaticResource{
    public static void main(String[] args) {
        SpringApplication.run(SpringbootStaticResource.class,args);
    }
}
