package com.xls.spring_mvc_ioc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestController {
    @RequestMapping("testRequest")
    @ResponseBody
    public String testRequest(){
        return this.toString();
    }
}
