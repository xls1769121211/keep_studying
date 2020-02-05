package com.xls.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 继承 AbstractAnnotationConfigDispatcherServletInitializer； 基于注解的MVC定制开发
 *
 *
 *
 *
 */
public class MyMVCConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer{


    //获取父容器  spring配置文件
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }
    //获取子容器  springMVC配置文件
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MVCConfig.class};
    }
    /**
     *     DispatherServlet 映射
     *
     *     / 拦截所有的请求 包括静态资源（js，html，css），不包括jsp，jsp是tomcat处理的
     *     /* 拦截所有包括 jsp文件
     */

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
