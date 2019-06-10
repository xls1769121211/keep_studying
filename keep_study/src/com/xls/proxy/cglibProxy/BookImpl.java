package com.xls.proxy.cglibProxy;

public class BookImpl implements Book{

    @Override
    public void read() {
        System.out.println("BookImpl.read");
    }
}
