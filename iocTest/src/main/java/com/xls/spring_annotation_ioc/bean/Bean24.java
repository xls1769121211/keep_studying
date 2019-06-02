package com.xls.spring_annotation_ioc.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *注解方式实现bean的初始化和销毁
 * 3种方式
 * 1 实现2个接口 InitializingBean DisposableBean
 *  2 通过2个注解实现
 *  3在配置类中实现
 */
//@Component

public class Bean24 implements InitializingBean, DisposableBean {


    public void destroy() throws Exception {
        System.out.println("Bean24.destroy");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean24.afterPropertiesSet");
    }
    @PostConstruct
    public void onInit(){
        System.out.println("Bean24.onInit");
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("Bean24.onDestroy");
    }

    public void onInit1(){
        System.out.println("Bean24.onInit1");
    }

    public void onDestroy1(){
        System.out.println("Bean24.onDestroy1");
    }
}
