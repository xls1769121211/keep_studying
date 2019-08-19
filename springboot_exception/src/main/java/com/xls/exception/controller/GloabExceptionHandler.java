package com.xls.exception.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理
 *
 * @ControllerAdvice + @ExceptionHandler
 */

@ControllerAdvice
public class GloabExceptionHandler{
    //@ExceptionHandler(value = {ArithmeticException.class,java.lang.NullPointerException.class})
    public ModelAndView testExceptionHandler(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("er",e.toString());
        modelAndView.setViewName("error_exception_handler");
        return modelAndView;
    }
}
