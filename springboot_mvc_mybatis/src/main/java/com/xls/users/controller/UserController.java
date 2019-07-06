package com.xls.users.controller;

import com.xls.users.domain.User;
import com.xls.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController{

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userList")
    public String queryAllUsers(Model model){
        List<User> users = userService.QueryAllUsers();
        model.addAttribute("users",users);
        return "userList";
    }

    @RequestMapping(value = "/addUser")
    public String insertUser(User user){
        userService.insertUser(user);
        return "userList";
    }

    /**
     * 页面跳转
     */
    @RequestMapping("/addUserPage")
    public String showPage(){
        return "addUser";
    }




}
