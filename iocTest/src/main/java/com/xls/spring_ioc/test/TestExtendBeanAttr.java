package com.xls.spring_ioc.test;

import com.xls.spring_ioc.bean.*;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试bean的继承属性注入的简化
 */
public class TestExtendBeanAttr {
    @Test
    public void Test(){
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("spring-extend.xml");


       Bean13 bean13 = (Bean13) context.getBean("bean13");
        System.out.println(bean13);
        Bean12 bean12 = (Bean12) context.getBean("bean12");
        System.out.println(bean12);


        Bean14 bean14 = (Bean14) context.getBean("bean14");
        System.out.println(bean14);
        Bean15 bean15 = (Bean15) context.getBean("bean15");
        System.out.println(bean15);
    }

}
