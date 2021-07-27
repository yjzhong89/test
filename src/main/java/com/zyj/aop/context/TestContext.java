package com.zyj.aop.context;

import com.zyj.aop.service.TestService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author zhongyj
 * @since 2021-04-13 17:16
 */
@Component
public class TestContext implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String[] beanNames = applicationContext.getBeanNamesForType(TestService.class);
        for (String beanName: beanNames) {
            TestService testService = (TestService) applicationContext.getBean(beanName);
            testService.test();
        }
    }
}
