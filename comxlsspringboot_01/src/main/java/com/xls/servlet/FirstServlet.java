package com.xls.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * spring boot 整合servlet 方式1
 * 使用@WebServlet注解
 *  name = "FirstServlet",servlet 名称
 *  urlPatterns = "/firstServlet" servlet url映射
 */
@WebServlet(name = "FirstServlet",urlPatterns = "/firstServlet")
public class FirstServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("firstServlet============");
        super.doGet(req, resp);
    }
}
