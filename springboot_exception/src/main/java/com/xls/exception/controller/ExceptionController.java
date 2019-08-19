package com.xls.exception.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.ExceptionHandler;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController{


    /**
     * 自定义错误页面，resources/templates/error.html 名称必须交error
     * @return
     */
    @RequestMapping(value = "/testCustomErrorPage")
    public String show1(){
        int i = 10/0;
        return  "";
    }



    /**
     * 异常处理方式一 @ExceptionHandler 注解处理具体异常
     */
    @RequestMapping(value = "/testExceptionHandler1")
    public String testExceptionHandler1(){
        String i = null;
        i.toString();
        return  "";
    }

    @RequestMapping(value = "/testExceptionHandler2")
    public String testExceptionHandler2(){
        int i = 10/0;
        return  "";
    }

    @ExceptionHandler(value = {java.lang.ArithmeticException.class,java.lang.NullPointerException.class})
    public ModelAndView testExceptionHandler(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("er",e.toString());
        modelAndView.setViewName("error_exception_handler");
        return modelAndView;
    }

}
