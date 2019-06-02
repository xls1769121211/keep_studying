package com.xls.spring_ioc.test;

import com.xls.spring_ioc.bean.Bean4;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringBean2 {

    @Test
    public void testInsertBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        Bean4 bean4 = (Bean4) context.getBean("bean4");
        System.out.println(bean4);
    }

}
