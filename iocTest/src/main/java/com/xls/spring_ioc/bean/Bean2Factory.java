package com.xls.spring_ioc.bean;

public class Bean2Factory {
    private static Bean2 getBean(){
        return new Bean2();
    }
}
