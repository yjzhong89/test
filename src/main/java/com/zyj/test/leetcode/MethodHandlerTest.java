package com.zyj.test.leetcode;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author zhongyj
 * @since 7/23/2021 4:58 PM
 */
public class MethodHandlerTest {
    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup l = MethodHandles.lookup();
        MethodType t = MethodType.methodType(void.class, Object.class);
        MethodHandle mh = l.findVirtual(MethodHandlerTest.class, "foo", t);
//        mh.invokeExact(new MethodHandlerTest(), new String());
        mh.invoke(new MethodHandlerTest(), new String());
    }

    public void foo(Object o) {
        System.out.println("---------");
    }
}
