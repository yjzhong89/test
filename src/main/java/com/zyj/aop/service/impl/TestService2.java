package com.zyj.aop.service.impl;

import com.zyj.aop.service.TestService;
import org.springframework.stereotype.Component;

/**
 * @author zhongyj
 * @since 2021-04-13 17:18
 */
@Component
public class TestService2 implements TestService {
    @Override
    public void test() {
        System.out.println("testService2");
    }
}
