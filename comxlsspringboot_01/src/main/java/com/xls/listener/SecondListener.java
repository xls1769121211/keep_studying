package com.xls.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * spring 整合Listener 方式二
 * 使用方法注册
 */
public class SecondListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Second Listener================");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
