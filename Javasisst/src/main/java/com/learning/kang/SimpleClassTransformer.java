package com.learning.kang;

import javassist.ClassPool;
import javassist.CtClass;

import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @program: mytest
 * @description:
 * @author: liu tiao
 * @create: 2019/11/25 20:32
 */
public class SimpleClassTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        ClassPool pool = null;
        CtClass ctClazz = null;
        try {
            pool = ClassPool.getDefault();
            if(className.contains("Service")){
                //获取类
                ctClazz = pool.makeClass(new ByteArrayInputStream(classfileBuffer));
                JavassistAnno annotation = (JavassistAnno) ctClazz.getAnnotation(JavassistAnno.class);
                if(annotation != null){
                    System.out.println("test-->"+annotation.desc());
                }
                return classfileBuffer;
            }
        }catch (Exception e){

        }
        return null;

    }
}
