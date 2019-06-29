package com.xls.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@RestController
public class HelloWorld{
    @RequestMapping("/helloWorld")
    public Map<String,Object> sayHello(){
        Map<String,Object> result = new HashMap<>();
        result.put("1","hello,刘二斤半");
        result.put("2","hello,world");
        return result;
    }
}
