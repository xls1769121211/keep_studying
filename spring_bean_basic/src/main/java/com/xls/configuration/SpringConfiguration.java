package com.xls.configuration;

import com.xls.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * spring 配置类
 */
@Configuration
@ComponentScan("com.xls")//包扫描开启
public class SpringConfiguration{
    @Bean
   // @Scope("singleton")//默认是singleton 单例模式 在容器启动时候创建bean
   // @Scope("prototype") //多例模式，请求的时候回去创建bean
    //@Scope("request") //一次请求重新创建在一个bean
    //@Scope("session") //一次session会话重新创建在一个bean
    public User User(){
        return  new User("111",12,"beijing");

    }
}
