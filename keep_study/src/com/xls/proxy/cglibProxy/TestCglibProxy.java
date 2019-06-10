package com.xls.proxy.cglibProxy;

public class TestCglibProxy {
    public static void main(String[] args) {
        BookProxy bookProxy = new BookProxy();

        BookImpl book  = (BookImpl)bookProxy.getInstance(new BookImpl());

        book.read();

    }
}
