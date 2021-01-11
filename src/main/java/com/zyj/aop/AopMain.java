package com.zyj.aop;

import com.zyj.aop.config.AppConfig;
import com.zyj.aop.test.IAopTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IAopTest test = context.getBean(IAopTest.class);
        test.test();
    }
}
