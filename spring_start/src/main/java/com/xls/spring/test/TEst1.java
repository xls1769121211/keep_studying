package com.xls.spring.test;

import com.xls.spring.aop.configuration.SpringConfiguration;
import com.xls.spring.aop.service.MathCalculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TEst1{
    public static void main(String[] args) {
        test1();
    }


    public static void test1(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        MathCalculator mathCalculator = (MathCalculator)annotationConfigApplicationContext.getBean("mathCalculator");

        mathCalculator.divide(1,0);
    }

}

