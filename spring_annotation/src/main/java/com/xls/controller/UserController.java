package com.xls.controller;

import com.xls.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController{
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
    public String say(){
      return userService.say();
    }

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public String hello2(){
        return "ssss";
    }

}
