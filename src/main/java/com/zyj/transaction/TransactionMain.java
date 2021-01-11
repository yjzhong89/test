package com.zyj.transaction;

import com.zyj.transaction.config.TransactionConfig;
import com.zyj.transaction.controller.TestController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhongyj
 * @since 2021-01-11 15:18
 */
public class TransactionMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TransactionConfig.class);
        TestController controller = context.getBean(TestController.class);
        controller.test();
    }
}
