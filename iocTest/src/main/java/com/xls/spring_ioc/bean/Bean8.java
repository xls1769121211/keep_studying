package com.xls.spring_ioc.bean;

public abstract class Bean8 {

    public abstract Bean9 createBean9();
    public void printBean9(){
        System.out.println(createBean9());
    }

}
