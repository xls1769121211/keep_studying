package com.xls.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * spring boot 整合Servlet方式二
 *
 */
@SpringBootApplication
public class ServletTest2{

    public static void main(String[] args) {
        SpringApplication.run(ServletTest2.class,args);
    }
    //在这里写 注册Servlet 的方法
    @Bean //注册到上下文中
    public ServletRegistrationBean setServletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new SecondServlet());
        servletRegistrationBean.setName("secondServlet");//设置Servlet名称
        servletRegistrationBean.addUrlMappings("/secondServlet");//设置url
        return servletRegistrationBean;
    }
}
