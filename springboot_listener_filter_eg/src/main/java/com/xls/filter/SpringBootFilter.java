package com.xls.filter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

/**
 * Spring boot 整合filter方式一
 *
 */
@SpringBootApplication
@ServletComponentScan
public class SpringBootFilter{
    public static void main(String[] args) {
        SpringApplication.run(SpringBootFilter.class,args);
    }

    //在这里注册 Filter的方法
    @Bean
    public FilterRegistrationBean getFilterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new SecondFilter());
        filterRegistrationBean.addUrlPatterns("/firstServlet");//添加过滤url
        return filterRegistrationBean;
    }
}
