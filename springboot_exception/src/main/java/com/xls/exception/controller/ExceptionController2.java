package com.xls.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController2{

    /**
     * 异常处理方式一 @ExceptionHandler 注解处理具体异常
     */
    @RequestMapping(value = "/testExceptionHandler3")
    public String testExceptionHandler1(){
        String i = null;
        i.toString();
        return  "";
    }

    @RequestMapping(value = "/testExceptionHandler4")
    public String testExceptionHandler2(){
        int i = 10/0;
        return  "";
    }


}
