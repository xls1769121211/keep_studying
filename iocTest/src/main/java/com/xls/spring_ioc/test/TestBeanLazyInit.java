package com.xls.spring_ioc.test;

import com.xls.spring_ioc.bean.Bean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanLazyInit {
    @Test
    public void Test(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-lazy.xml");
        System.out.println("context加载完毕");
       Bean  bean = (Bean) context.getBean("bean01");
        System.out.println(bean);
    }
}
