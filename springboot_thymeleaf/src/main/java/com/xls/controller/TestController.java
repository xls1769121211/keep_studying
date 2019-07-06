package com.xls.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class TestController{

    @RequestMapping("/testString")
    public  String TestString(Model model){
        model.addAttribute("string","我们的爱像在青春的纪念册");
        model.addAttribute("english","I Am Ironman");
        return  "testString";
    }

    @RequestMapping("/testDate")
    public  String TestDate(Model model){
        model.addAttribute("now",new Date());
        return  "testDate";
    }

    @RequestMapping("/testIf")
    public  String testIf(Model model){
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("nnn");
        list.add("ccc");
        model.addAttribute("sex","男");
        model.addAttribute("list",list);

        Map<String,Object> map = new HashMap<>();
        map.put("aaa","111111");
        map.put("bbb","222222");
        map.put("ccc","333333");
        model.addAttribute("map",map);

        return  "testIfElse";
    }


    @RequestMapping("/testScopeObject")
    public  String testScopeObject(HttpServletRequest request, HttpSession session){
        //域对象操作
        request.setAttribute("request","aaaaaaaa");

        session.setAttribute("session","bbbbbbbb");

        session.getServletContext().setAttribute("app","application");

        return  "testScopeObject";
    }


    @RequestMapping("/testUrl")
    public  String testUrl(){
        return  "testUrl";
    }

    @RequestMapping("/{id}/testUrlParam")
    public  String testUrl(@PathVariable String id,HttpServletRequest request){
        System.out.println("id = [" + id + "]");
        request.setAttribute("request",id);
        return  "testScopeObject";
    }
}
