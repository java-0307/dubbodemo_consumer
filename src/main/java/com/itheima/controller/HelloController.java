package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @author: shiwei zhao
 * @create: 2020-02-29 11:43
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    //启动检查默认是true
    @Reference(check = false,loadbalance = "random")
    private HelloService helloService;

    @RequestMapping("/say")
    @ResponseBody
    public String sayHello(String name){
        return helloService.sayHello(name);
    }
}