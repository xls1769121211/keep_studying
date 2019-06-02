package com.xls.spring_ioc.test;

import com.xls.spring_ioc.bean.Bean4;
import com.xls.spring_ioc.bean.Bean6;
import com.xls.spring_ioc.bean.Bean8;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringBean3 {

    @Test
    public void testInsertBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean1.xml");
        //默认都是单例模式 两次的bean得到的bean7 都是相同的 但是有局限性 是在一个上下文中
        Bean6 bean6 = (Bean6) context.getBean("bean6");
        System.out.println(bean6);

        Bean6 bean6_1 = (Bean6) context.getBean("bean6");
        System.out.println(bean6.getClass());
        System.out.println(bean6_1);

        System.out.println("bean6 == bean6_1 ======= "+(bean6 == bean6_1));

        Bean8 bean8 = (Bean8) context.getBean("bean8");
        bean8.printBean9();
        bean8.printBean9();
        bean8.printBean9();
        bean8.printBean9();
        bean8.printBean9();
    }

}
