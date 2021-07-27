package com.zyj.test.leetcode;

/**
 * @author zhongyj
 * @since 2021-04-19 17:27
 */
public class Test115 {
    public static void main(String[] args) {

    }
    Integer[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int x = text1.length();
        int y = text2.length();
        memo = new Integer[x][y];
        return dfs(text1, text2, x - 1, y - 1);
    }

    private int dfs(String text1, String text2, int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }
        if (memo[x][y] != null) {
            return memo[x][y];
        }

        int res = 0;
        if (text1.charAt(x) == text2.charAt(y)) {
            // 当前位置相等，需要加1
            res = dfs(text1, text2, x - 1, y - 1) + 1;
        } else {
            res = Math.max(dfs(text1, text2, x, y - 1), dfs(text1, text2, x - 1, y));
        }

        memo[x][y] = res;
        return res;
    }
}
