package com.xls;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 基于注解的Servlet开发
 * 在Servlet类上加上注解 @WebServlet(urlPatterns = {"/hello","/aaaa"})
 *
 * 类似 监听器 加@WebListener，过滤器加@WebFileer
 *
 */
//@WebListener
public class ListenerTest implements ServletRequestListener{


    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("requestInitialized");
    }
}
