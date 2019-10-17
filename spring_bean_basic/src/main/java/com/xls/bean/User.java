package com.xls.bean;

import org.springframework.stereotype.Component;

@Component(value = "user")
public class User{
    private String userName;
    private Integer age;
    private String city;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public User(){}
    public User(String userName, Integer age, String city) {
        this.userName = userName;
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
