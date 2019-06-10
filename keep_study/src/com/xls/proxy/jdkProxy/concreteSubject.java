package com.xls.proxy.jdkProxy;

public class concreteSubject implements Subject {

    @Override
    public void request() {
        System.out.println("concreteSubject.request");
    }
}
