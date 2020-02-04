package com.xls.spring.test;

import com.xls.spring.ext.configuration.SpringExtConfiguration;
import com.xls.spring.tx.configuration.SpringTxConfiguration;
import com.xls.spring.tx.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3{
    public static void main(String[] args) {
        test1();
    }


    public static void test1(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringExtConfiguration.class);

    }

}

