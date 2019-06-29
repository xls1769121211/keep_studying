package com.xls.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 *spring boot 整合Filter 方式二
 * 以方法注册的方式整合 和 Servlet 类似
 *
 */
public class SecondFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("secondFilter===============");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
