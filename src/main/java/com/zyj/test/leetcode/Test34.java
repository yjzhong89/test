package com.zyj.test.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhongyj
 * @since 2021-03-26 10:57
 */
public class Test34 {
    public static void main(String[] args) {
        Test34 test34 = new Test34();
        int[] list = new int[] {5,7,7,8,8,8,10};
        test34.findNumber(list, 8).forEach(System.out::println);
    }

    public List<Integer> findNumber(int[] list, int target) {
        List<Integer> result = Arrays.asList(-1, -1);
        int len = list.length;
        // 如果长度为0，直接返回
        if (len == 0) {
            return result;
        }
        // 如果长度为1，直接比较返回
        if (len == 1) {
            result.add(target == list[0] ? 0 : -1);
            result.add(target == list[0] ? 0 : -1);
            return result;
        }

        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (list[middle] == target) {
                // 如果正好等于中间值，需要向两边扩展
                int a = middle;
                int b = middle;
                while (a >= 0) {
                    if (list[a] == target) {
                        result.set(0, a);
                        a--;
                    } else {
                        break;
                    }
                }

                while (b <= len - 1) {
                    if (list[b] == target) {
                        result.set(1, b);
                        b++;
                    } else {
                        break;
                    }
                }

                return result;
            } else {
                if (target > list[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return result;
    }
}
