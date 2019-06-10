package com.xls.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * jdk 动态代理
 * 实现 InvocationHandler  接口
 */
public class SubjectProxy implements InvocationHandler {
    private Object obj;
    public SubjectProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling===============");
        method.invoke(obj,args);
        System.out.println("after calling===============");
        return null;
    }
}
