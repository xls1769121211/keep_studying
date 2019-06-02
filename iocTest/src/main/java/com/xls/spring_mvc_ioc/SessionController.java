package com.xls.spring_mvc_ioc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SessionController {
    @RequestMapping("testSession")
    @ResponseBody
    public String testSession(){
        return this.toString();
    }
}
