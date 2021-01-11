package com.zyj.aop.pointcut;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCut {

    @Pointcut("execution(* com.zyj.aop.test.*.*(..))")
    public void pointcut(){

    }

    @Before("com.zyj.aop.pointcut.PointCut.pointcut()")
    public void before() {
        System.out.println("--- before ---");
    }

    @After("com.zyj.aop.pointcut.PointCut.pointcut()")
    public void after() {
        System.out.println("--- after ---");
    }

    @AfterReturning("com.zyj.aop.pointcut.PointCut.pointcut()")
    public void afterReturn() {
        System.out.println("--- after return ---");
    }

    @AfterThrowing("com.zyj.aop.pointcut.PointCut.pointcut()")
    public void afterThrow() {
        System.out.println("--- after throw ---");
    }
}
