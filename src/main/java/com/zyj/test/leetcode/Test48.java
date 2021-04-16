package com.zyj.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhongyj
 * @since 2021-03-27 16:29
 */
public class Test48 {
    /**
     * (0, 0) -> (0, 2)
     * (1, 0) -> (0, 1)
     * (2, 1) -> (1, 0)
     * (0, 2) -> (2, 2)
     *
     * (i, j) -> (j, len - 1 - i)
     *
     * (x, y) ->
     */
    public static void main(String[] args) {
        int[][] list = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        Test48 test48 = new Test48();
        test48.rotate90(list);
    }

    public void rotate90(int[][] list) {
        Map<Integer, Integer> map = new HashMap<>(16);
        int length = list.length;
        int len = list.length / 2 + list.length % 2;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1; j++) {
                int k = 4;
                int temp = 0;
                int h = i;
                int l = j;
                while (k > 0) {
                    temp = list[l][length - 1 - h];
                    list[l][length - 1 - h] = list[h][l];
                    k--;
                }
            }
        }
    }
}
