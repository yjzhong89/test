package com.zyj.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhongyj
 * @since 2021-04-15 10:46
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,2,1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1024));
        threadPoolExecutor.execute(() -> System.out.println("abc"));
        threadPoolExecutor.shutdown();
    }
}
