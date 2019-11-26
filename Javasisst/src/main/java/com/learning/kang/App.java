package com.learning.kang;

import java.lang.instrument.Instrumentation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HelloService helloService = new HelloServiceImpl();
        helloService.sayHello(" Today");
    }

    public static void premain(String agentArgs, Instrumentation inst)
    {
        System.out.println( "=========开始执行premain============" );
        SimpleClassTransformer transformer = new SimpleClassTransformer();
        inst.addTransformer(transformer);
    }
}
