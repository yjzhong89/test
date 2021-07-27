package com.zyj.test.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhongyj
 * @since 2021-04-22 13:33
 */
public class Test94 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "bcd");
        System.out.println(list);

        int[] list1 = new int[]{1, 2, 3};
        System.out.println(list1);
        Map map = new HashMap();
        map.put(0, 0);
        map.put(1, 1);
//        List list2 = map.values().forEach();
        System.out.println(map.values());
    }
}
