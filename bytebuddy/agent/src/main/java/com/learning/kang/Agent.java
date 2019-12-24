package com.learning.kang;


import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

public class Agent
{
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("agentArgs--->"+agentArgs);
        new AgentBuilder.Default()
                .type(ElementMatchers.nameStartsWith("com.learning.kang.bytebuddy"))// 指定需要拦截的类
                .transform((builder, type, classLoader, module) ->
                        builder.method(ElementMatchers.any())
                                .intercept(MethodDelegation.to(ByteBuddyInterceptor.class)))
                .installOn(inst);
    }
}
