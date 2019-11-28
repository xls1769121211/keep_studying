package com.xls.entry;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 人员类
 */
public class People implements InitializingBean, DisposableBean{
    private String name;
    private Integer age;

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public void initP(){
        System.out.println("people初始化.......initMethod");
    }

    public void destroyP(){
        System.out.println("people销毁.......destroyMethod");
    }

    public void destroy() throws Exception {
        System.out.println("people销毁.......DisposableBean");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("people初始化.......InitializingBean");
    }
}
