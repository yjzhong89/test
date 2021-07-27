package com.zyj.test.leetcode;

/**
 * @author zhongyj
 * @since 2021-03-27 15:27
 */
public class Test42 {

    public int collectRain(int[] list) {
        int maxIndex = 0;
        int secondMaxIndex = 0;
        int left = 0;
        int total = 0;
        for (int i = 0; i < list.length; i++) {
            if (maxIndex < list[i]) {
                maxIndex = i;
            }
        }
        return 0;
    }
}
