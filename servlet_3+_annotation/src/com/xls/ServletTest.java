package com.xls;

import javax.servlet.ServletException;
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
//@WebServlet(urlPatterns = {"/hello","/aaaa"})
public class ServletTest extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("hello.....");
    }
}
