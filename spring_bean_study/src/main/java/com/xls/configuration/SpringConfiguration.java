package com.xls.configuration;

import com.xls.Conditionnal.LinuxConditional;
import com.xls.Conditionnal.WindowsConditional;
import com.xls.entry.Car;
import com.xls.entry.Cat;
import com.xls.entry.Color;
import com.xls.entry.User;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;


/**
 * Spring 配置类
 */
@Configuration
//@ComponentScan(value = "com.xls")
//,includeFilters = {
////        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Service.class}),
////        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = {Car.class})
//        //@ComponentScan.Filter(type = FilterType.ASPECTJ,value = {})
//        //@ComponentScan.Filter(type = FilterType.CUSTOM,value = {MyFilter.class})//自定义过滤规则
//},useDefaultFilters = false)
//@Import({Color.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})//导入需要注册的bean
public class SpringConfiguration {

    @Bean //注册bean
    @Lazy
    public User user1(){
        return new User("xls",18);
    }


    @Bean(name = "bill")//注册bean

    @Conditional(value = {WindowsConditional.class})
    public User user2(){
        return new User("jobs",58);
    }

    @Bean(name = "linux")//注册bean
    @Conditional(value = {LinuxConditional.class})
    public User user3(){
        return new User("linux",38);
    }


    //使用factoryBean 注册 bean
    @Bean
    public MyFactoryBean myFactoryBean(){
        return  new MyFactoryBean();
    }

}
