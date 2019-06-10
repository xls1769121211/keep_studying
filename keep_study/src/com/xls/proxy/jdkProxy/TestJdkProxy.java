package com.xls.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestJdkProxy {
    public static void main(String[] args) {
        //要代理的目标类
        concreteSubject concreteSubject = new concreteSubject();
        //获取代理类InvocationHandler
        InvocationHandler handler  = new SubjectProxy(concreteSubject);

        //生成代理类
        Subject subject =  (Subject) Proxy.newProxyInstance(concreteSubject.getClass().getClassLoader(),concreteSubject.getClass().getInterfaces(),handler);
        subject.request();
        System.out.println("subject=========");
        System.out.println(subject);
    }
}
