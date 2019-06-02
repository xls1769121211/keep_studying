package com.xls.spring_ioc.test;


import com.xls.spring_ioc.bean.Bean10;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringBeanCustomScope {

    @Test
    public void TestSpringBeanCustomScope(){
       final ApplicationContext context = new
                ClassPathXmlApplicationContext("spring-bean2.xml");

        for (int i = 0; i < 10; i++) {
            Bean10 bean10 = (Bean10) context.getBean("bean10");
            System.out.println("111---"+bean10);
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    Bean10 bean10 = (Bean10) context.getBean("bean10");
                    System.out.println("222------"+bean10);
                }
            }).start();
        }
    }

}
