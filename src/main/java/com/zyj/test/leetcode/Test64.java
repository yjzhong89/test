package com.zyj.test.leetcode;

/**
 * @author zhongyj
 * @since 2021-04-06 17:30
 */
public class Test64 {
    public static void main(String[] args) {
        int[][] board = new int[][]{{1, 2, 3}, {4, 5, 6}};
        Test64 test64 = new Test64();
        System.out.println(test64.getMinPath(board));
    }

    public int getMinPath(int[][] board) {
        int x = board.length;
        int y = board[0].length;

        if (board == null || x == 0 || y == 0) {
            return 0;
        }

        int[][] dp = new int[x][y];
        dp[0][0] = board[0][0];

        for (int i = 1; i < x; i++) {
            dp[i][0] = dp[i - 1][0] + board[i][0];
        }

        for (int j = 1; j < y; j++) {
            dp[0][j] = dp[0][j - 1] + board[0][j];
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + board[i][j];
            }

        }
        return dp[x - 1][y - 1];
    }
}
