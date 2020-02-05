package com.xls;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.*;

/**
 * 基于注解的 servlet 异步请求
 * 需要打开支持异步，如果不打开，
 * @WebServlet(urlPatterns = {"/helloAsync"},asyncSupported = true)
 *
 */
@WebServlet(urlPatterns = {"/helloAsync"},asyncSupported = true)
public class ServletTestAsync extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("主线程开始====="+Thread.currentThread().getName());
       // 1 开启异步支持 asyncSupported = true
       AsyncContext context =  req.startAsync();
       // 2异步开始
       context.start(() -> {
           try {
               doSomething();
               //3 异步完成之后 响应
               context.complete();
               context.getResponse().getWriter().write("async sucess......");
           } catch (Exception e) {
               e.printStackTrace();
           }
       });
        System.out.println("主线程结束====="+Thread.currentThread().getName());
    }
    public void doSomething() throws Exception {
        System.out.println("副线程开始====="+Thread.currentThread().getName());

        Thread.sleep(3000);
        System.out.println("副线程 processing.....");

        System.out.println("副线程结束====="+Thread.currentThread().getName());
    }
}
