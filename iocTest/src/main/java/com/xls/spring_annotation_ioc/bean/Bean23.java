package com.xls.spring_annotation_ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *注解方式实现bean的作用域
 */
@Component
public abstract class Bean23 {

    public abstract Bean22 getBean22();

    public void print(){
        System.out.println("Bean23.print+"+getBean22());
    }
}
