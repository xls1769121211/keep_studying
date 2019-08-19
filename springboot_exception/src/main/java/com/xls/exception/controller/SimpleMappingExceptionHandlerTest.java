package com.xls.exception.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * 使用SimpleMappingExceptionResolver配置全局异常处理
 *
 */
@Configuration
public class SimpleMappingExceptionHandlerTest{

    /**
     * 使用SimpleMappingExceptionResolver 配置全局异常处理
     * 返回值必须是
     * @return
     */
   // @Bean
    public SimpleMappingExceptionResolver SimpleMappingExceptionHandlerTest(){

        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties exceptionMappings = new Properties();
        exceptionMappings.setProperty("java.lang.NullPointerException","error_NullPointException");
        exceptionMappings.setProperty("java.lang.ArithmeticException","error_ArithmeticException");
        resolver.setExceptionMappings(exceptionMappings);
        return resolver;
    }

}
