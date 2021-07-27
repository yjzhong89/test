package com.zyj.test.leetcode;

/**
 * @author zhongyj
 * @since 2021-04-06 16:57
 */
public class Test62 {
    public static void main(String[] args) {
        Test62 test62 = new Test62();
        System.out.println(test62.getAllRoute(3, 2));
    }

    public int getAllRoute(int x, int y) {
        int[][] finish = new int[x][y];
        for (int i = 0; i < x; i++) {
            finish[i][0] = 1;
        }
        for (int j = 0; j < y; j++) {
            finish[0][j] = 1;
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                finish[i][j] = finish[i - 1][j] + finish[i][j - 1];
            }
        }
        return finish[x - 1][y - 1];
    }
}
