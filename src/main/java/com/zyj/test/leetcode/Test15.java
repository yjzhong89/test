package com.zyj.test;

import java.util.*;

/**
 * @author zhongyj
 * @since 2021-03-18 14:34
 */
public class Test15 {
    public static void main(String[] args) {
        int[] num = new int[]{-1, 0, 1, 2, -1, -4};
        threeNumSum(num);
    }

    public static void threeNumSum(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        int len = num.length;
        for (int i = 0; i < len; i++) {
            if (num[i] > 0) {
                break;
            }
            if (i > 0 && num[i] == num[i -1]) {
                continue;
            }
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum == 0) {
                    result.add(Arrays.asList(num[i], num[left], num[right]));
                    while (num[left] == num[left + 1] && left < right ) {
                        left++;
                    }
                    while (num[right] == num[right - 1] && left < right ) {
                        right--;
                    }
                    left++;
                    right--;
                }
                if (sum > 0) {
                    right--;
                }
                if (sum < 0) {
                    left++;
                }
            }
        }
    }
}
