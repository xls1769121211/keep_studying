package com.xls.test;

import com.xls.bean.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试启动类
 */
public class mainTest{
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean-config.xml");


        User user = (User)context.getBean("user");

        System.out.println(user);
    }
}
