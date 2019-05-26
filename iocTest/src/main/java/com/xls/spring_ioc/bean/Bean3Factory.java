package com.xls.spring_ioc.bean;

public class Bean3Factory {
    private  Bean3 getBean(){
        return new Bean3();
    }
}
