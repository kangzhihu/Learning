package com.learning.kang.bytebuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.learning.kang.bytebuddy.service.HelloService;

/**
 * @program: bytebuddy
 * @description:
 * @author: liu tiao
 * @create: 2019/12/24 14:46
 */
@Controller
public class ExampleController {

    @Autowired
    HelloService helloService;

    @ResponseBody
    @GetMapping("/hello/{content}")
    public String hello(@PathVariable("content")String content){
        return helloService.sayHello(content);
    }
}
