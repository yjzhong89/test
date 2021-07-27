package com.zyj.aop.test;

import org.springframework.stereotype.Component;

@Component
public class AopTest implements IAopTest {
    @Override
    public void test() {
        System.out.println("--- test ---");
        System.out.println(TestEnum.MSG_STATUS.getStatus());
    }
}
