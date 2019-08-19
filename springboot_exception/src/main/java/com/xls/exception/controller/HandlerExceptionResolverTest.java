package com.xls.exception.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * 通过实现 HandlerExceptionResolve 接口来处理异常信息
 *
 */
@Configuration
public class HandlerExceptionResolverTest implements HandlerExceptionResolver{

    private static  final Logger log = Logger.getLogger(HandlerExceptionResolverTest.class.getName());

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        log.info("resolveException============================房间看法大D大调D分开了而我却若群无若");
        //判断异常的类别返回不同的视图
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof ArithmeticException){
            modelAndView.setViewName("error_ArithmeticException");
        }else if (e instanceof  NullPointerException){
            modelAndView.setViewName("error_NullPointException");
        }
        modelAndView.addObject("error",e.getStackTrace());
        return modelAndView;
    }
}
