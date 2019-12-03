package com.xls.entry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class     Dog implements BeanPostProcessor{
    public Dog() {
    }
    @PostConstruct
    public void initD(){
        System.out.println("init.....dog");
    }

    @PreDestroy
    public void destroyD(){
        System.out.println("destroy.....dog");
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization.....dog---->"+beanName);
        return  bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization.....dog----->"+beanName);
        return  bean;
    }
}
