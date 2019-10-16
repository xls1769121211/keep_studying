package xls.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xls.interfaces.HelloService;

@RestController
public class HtlloController{
    @Reference
    private HelloService helloService;


    @RequestMapping("/hello/{name}")
    public void sayhello(@PathVariable String name){
        helloService.sayHello(name);
    }


}
