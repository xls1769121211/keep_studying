package com.xls.test;

import com.xls.bean.User;
import com.xls.configuration.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试启动类
 */
public class mainTest{
    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }

//   使用xml来 配置bean
    private static void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean-config.xml");
        User user = (User)context.getBean("user");
        System.out.println(user);
    }


    //使用注解来注册bean
    private static void test2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        User user = (User)context.getBean("User");
        User user2 = (User)context.getBean("User");
        System.out.println(user == user2);
    }

    //使用注解和包扫描来注册bean
    private static void test3() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //打印所有已经注入的bean
        printAllBeans(context);
    }

    private static void printAllBeans(ApplicationContext context){
      String []names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

    }
}
