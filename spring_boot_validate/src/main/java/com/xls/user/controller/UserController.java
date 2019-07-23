package com.xls.user.controller;

import com.xls.user.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * 用户控制层
 */

@Controller
public class UserController {

    /**
     * 去添加用户页面
     * 加一个参数user 主要是为了定义在modelAndView中实体的key，避免异常
     */
    @RequestMapping(value = "/showAddUser")
    public String showAddUser(@ModelAttribute("u") User user){
        return "addUser";
    }


    /**
     * 添加用户的方法
     * @param user
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(@ModelAttribute("u") @Valid User user, BindingResult result){
        //如果有错误，返回到添加用户页面并展示错误信息
        if (result.hasErrors()){
            System.out.println(result);
            return "addUser";
        }
        System.out.println("添加成功======");
        System.out.println(user);
        return  "ok";
    }
}
