package com.xls.Service;

import org.springframework.stereotype.Service;

@Service
public class UserService{
    public String say(){
        System.out.println("hello...Service");
        return "hello";
    }
}
