package com.xls.spring_annotation_ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *注解方式实现bean的作用域
 */
@Component
@Scope(value = "myscope")
public  class Bean21 {
    @Autowired
    private Bean20 bean20;




}
