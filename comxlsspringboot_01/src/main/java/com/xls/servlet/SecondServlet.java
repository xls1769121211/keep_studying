package com.xls.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * spring boot 整合Servlet 方式二
 * 以方法注册到上下文中的方式 实现Servlet的整合
 */
public class SecondServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Second Servlet ========================");
        super.doGet(req, resp);
    }
}
