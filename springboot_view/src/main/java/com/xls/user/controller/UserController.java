package com.xls.user.controller;

import com.xls.user.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * controller
 */
@Controller
public class UserController{


    @RequestMapping("/showUser")
    private String showUser(Model model){
        List<User> users = new ArrayList<>();
        users.add(new User("1","张三1",18));
        users.add(new User("2","张三2",182));
        users.add(new User("3","张三3w",16));
        model.addAttribute("users",users);
        return  "userList";
    }

    @RequestMapping("/showUserTemplate")
    private String showUserTemplate(Model model){
        List<User> users = new ArrayList<>();
        users.add(new User("4ss","张三11",18));
        users.add(new User("5ss","张三2",182));
        users.add(new User("6ss","张三3",16));
        model.addAttribute("users",users);
        return  "userList_tem";
    }

}
