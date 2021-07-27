package com.zyj.test.leetcode;

import java.util.*;

/**
 * @author zhongyj
 * @since 2021-04-19 13:01
 */
public class Test53 {
    public static void main(String[] args) {
        int[] list = new int[]{5, 4, -1, 7, 8};
        System.out.println(new Test53().maxSubArray(list));
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
            map.put(result, i);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        if (list.get(0) >= 0) {
            return list.get(list.size() - 1);
        } else {
            return list.get(list.size() - 1) - list.get(0);
        }
    }
}
