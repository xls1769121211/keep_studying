package com.xls.configuration;

import com.xls.entry.Cat;
import com.xls.entry.Dog;
import com.xls.entry.People;
import com.xls.entry.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 使用@profile 为不同的环境注册不同的bean 动态切换和激活
 *      环境激活方式：(1) 命令行 激活 启动时加入vm变量 -Dspring.profiles.active = dev
 *                    (2) 代码手动激活方式 设置  annotationConfigApplicationContext.getEnvironment().setActiveProfiles("test");
 *
 * 1 直接在bean上加@profile("dev") 的注解，"dev"是各个环境的定义 加了环境标识的bean只有当这个环境被激活的时候这个bean才会加载到ioc容器中 默认值是default
 * 2 写在配置类上，只有当配置类和运行环境上一致时，配置类的其他配置才会生效
 * 3 不论什么环境，不加@Profile的Bean都能加载到ioc容器中
 */
@Configuration
@ComponentScan("com.xls.controller")
public class SpringConfiguration3{
    @Profile("dev")
    @Bean
    public Dog dog(){
        return  new Dog();
    }
    @Profile("test")
    @Bean
    public User User(){
        return  new User();
    }
    @Bean
    public People people(){
        return new People();
    }
}
