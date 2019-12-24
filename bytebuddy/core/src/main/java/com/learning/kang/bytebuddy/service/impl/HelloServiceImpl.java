package com.learning.kang.bytebuddy.service.impl;

import org.springframework.stereotype.Service;
import com.learning.kang.bytebuddy.service.HelloService;

/**
 * @program: mytest
 * @description: ces
 * @author: liu tiao
 * @create: 2019/11/25 20:50
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String content) {
        return "hi, "+content;
    }
}
