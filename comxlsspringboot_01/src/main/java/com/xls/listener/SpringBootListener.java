package com.xls.listener;


import com.xls.filter.SecondFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Spring boot 整合filter方式一
 *
 */
@SpringBootApplication
@ServletComponentScan
public class SpringBootListener{
    public static void main(String[] args) {
        SpringApplication.run(SpringBootListener.class,args);
    }

    @Bean
    //在这里写方法注册Listener
    public ServletListenerRegistrationBean getServletListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(new SecondListener());
        return  servletListenerRegistrationBean;
    }
}
