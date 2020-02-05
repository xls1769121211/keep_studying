package com.xls.controller;

import com.xls.Service.UserQueue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * spring mvc异步请求
 * 方式1 方法返回Callable<?> 子线程返回的结果会返回给Callable
 *
 * 方式2 返回DeferredResult
 */
@Controller
public class AsyncController {
    @ResponseBody
    @RequestMapping(value = "/sayHello2",method = RequestMethod.GET)
    public Callable<String> say(){
        System.out.println("主线程开始。。。。。"+Thread.currentThread().getName());
        Callable<String> stringCallable = new Callable<String>(){
            @Override
            public String call() throws Exception {
                System.out.println("子线程开始。。。。。"+Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.println("子线程结束。。。。。"+Thread.currentThread().getName());
                return "xllxxllxxl";
            }
        };
        System.out.println("主线程结束。。。。。"+Thread.currentThread().getName());
        return  stringCallable;
    }



    @ResponseBody
    @RequestMapping(value = "/sayHello4",method = RequestMethod.GET)
    public DeferredResult<String> sayHello4() throws InterruptedException {
        System.out.println("主线程开始。。。。。"+Thread.currentThread().getName());
        DeferredResult<String> deferredResult = new DeferredResult<>();
        UserQueue.add(deferredResult);
        System.out.println("主线程结束。。。。。"+Thread.currentThread().getName());
        return  deferredResult;
    }


    @ResponseBody
    @RequestMapping(value = "/sayHello5",method = RequestMethod.GET)
    public String sayHello5(){
        System.out.println("zi线程开始。。。。。"+Thread.currentThread().getName());
        String uuid = UUID.randomUUID().toString();
        DeferredResult<String> deferredResult = UserQueue.get();
        deferredResult.setResult(uuid);
        System.out.println("zi线程结束。。。。。"+Thread.currentThread().getName());
        return uuid;
    }
}
