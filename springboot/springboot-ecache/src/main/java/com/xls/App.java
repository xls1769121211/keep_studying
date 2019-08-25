package com.xls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * spring boot 整合ehcache
   加入配置文件 ehcache.xml
 * 在启动程序加@EnableCaching
 * 在serviceImpl 具体的方法加入@Cacheable
 * 要缓存的实体类需要实现serializable 接口
 */

@SpringBootApplication
@EnableCaching
public class App{
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
