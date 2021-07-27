package com.zyj.test.leetcode;

import java.util.*;

/**
 * @author zhongyj
 * @since 2021-04-19 11:30
 */
public class Test70 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Collections.sort(new ArrayList<>(map.keySet()));
        System.out.println(new Test70().climbStairs(3));
    }

    Integer[] memo;
    public int climbStairs(int n) {
        memo = new Integer[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        if (memo[n] != null) {
            return memo[n];
        }

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
