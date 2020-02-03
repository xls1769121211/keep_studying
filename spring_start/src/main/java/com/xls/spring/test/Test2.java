package com.xls.spring.test;

import com.xls.spring.aop.configuration.SpringConfiguration;
import com.xls.spring.aop.service.MathCalculator;
import com.xls.spring.tx.configuration.SpringTxConfiguration;
import com.xls.spring.tx.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2{
    public static void main(String[] args) {
        test1();
    }


    public static void test1(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringTxConfiguration.class);

        UserService userService = annotationConfigApplicationContext.getBean(UserService.class);

        userService.insert();
    }

}

