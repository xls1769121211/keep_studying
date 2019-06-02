package com.xls.spring_annotation_ioc.bean;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @lazy如果加载配置类上 则下面所含有的bean都是懒加载的
 */
@Configuration
@ComponentScan(value = "com.xls.spring_annotation_ioc.bean")
@Lazy
public class MyConfigure {

    /**
     * 通过@Bean 来标注 也可以取多个别名
     * xml中 取别名用 <alias name="" alias=""></alias>标签
     * 在注解中直接用 {"aaa"，"bbbb'}
     * @return
     */
    @Bean(name = {"aaa","bbb"})
    public Bean16 Bean16(){
        return  new Bean16();
    }

/*
    @Bean
    public List<String> stringList(){
        List<String> bean19s = new ArrayList<String>();
        bean19s.add("1234");
        return bean19s;
    }*/

    @Bean(name = "stringList")
    public List<String> stringList(){
        List<String> strings = new ArrayList<String>();
        strings.add("123456");
        return  strings;
    }

    /**
     * 使用注解实现定义作用域
     * 1.定义自己的scope bean
     * 2.加入到org.springframework.beans.factory.config.CustomScopeConfigurer
     */
    @Bean
    public  MyCustomScope getScope(){
        return  new MyCustomScope();
    }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer(){
        CustomScopeConfigurer customScope = new CustomScopeConfigurer();
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("myscope",getScope());
        customScope.setScopes(param);
        return  customScope;
    }


    @Bean(initMethod = "onInit1",destroyMethod = "onDestroy1")

    public Bean24 bean24(){
        return new Bean24();
    }


}
