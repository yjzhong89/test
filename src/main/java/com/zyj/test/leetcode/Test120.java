package com.zyj.test.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhongyj
 * @since 2021-04-19 18:55
 */
public class Test120 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(2);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<Integer> list3 = Arrays.asList(6, 5, 7);
        List<Integer> list4 = Arrays.asList(4, 1, 8, 3);
        List<List<Integer>> list = Arrays.asList(list1, list2, list3, list4);
        System.out.println(new Test120().minimumTotal(list));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int x = triangle.size();
        int y = triangle.size();
        int[][] memo = new int[x + 1][y + 1];
        for (int i = x - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                memo[i][j] = Math.min(memo[i + 1][j], memo[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return memo[0][0];
    }
}
