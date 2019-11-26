package com.learning.kang;

/**
 * @program: mytest
 * @description: ces
 * @author: liu tiao
 * @create: 2019/11/25 20:50
 */
@JavassistAnno(desc = "class anno")
public class HelloServiceImpl implements HelloService{
    @Override
    @JavassistAnno(desc = "method anno")
    public void sayHello(String content) {
        System.out.println("hi, "+content);
    }
}
