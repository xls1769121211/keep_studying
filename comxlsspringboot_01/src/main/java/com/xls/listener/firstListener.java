package com.xls.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * spring boot 整合listener 方式一
 * 使用@WebListener注解 类 实现 ServletContextListener
 *
 */

@WebListener
public class firstListener implements ServletRequestListener{
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("监听每次请求==========="+sre);
    }
}
