package com.zyj.test.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhongyj
 * @since 2021-03-17 14:23
 * 给定一个数组和一个数，找到数组中两个数相加和等于这个数
 * 思路   1. 用一个map和一个循环
 *        2. 每次将下标作为值，该下标对应值与目标数的差作为key
 *        3. 每次判断循环到的值有没有在map中对应的key
 */
public class TwoNumSum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 12, 15);
        int target = 14;
        TwoNumSum twoNumSum = new TwoNumSum();
        twoNumSum.findTwoNum(list, target);
    }

    public void findTwoNum(List<Integer> list, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> resultMap = new HashMap<>(16);

        for (int i = 0; i < list.size(); i++) {
            if (resultMap.containsKey(list.get(i))) {
                result[0] = i;
                result[1] = resultMap.get(list.get(i));
            }
            resultMap.put(target - list.get(i), i);
        }
        System.out.println(result[0] + " " + result[1]);
    }
}
