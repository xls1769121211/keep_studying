package com.xls.spring_ioc.test;

import com.xls.spring_ioc.bean.Bean;
import com.xls.spring_ioc.bean.Bean2;
import com.xls.spring_ioc.bean.Bean3;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringBean {

    @Test
    public void start(){
        //使用构造方法创建BEAN
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Bean bean = (Bean) context.getBean("bean01");
        System.out.println("bean="+bean);
        //使用静态方法创建BEAN
        Bean2 bean2 = context.getBean("bean2",Bean2.class);
        System.out.println("bean2="+bean2);
        //通过实例方法创建BEAN
        Bean3 bean3 = context.getBean("bean3",Bean3.class);
        System.out.println("bean3="+bean3);

    }
}
