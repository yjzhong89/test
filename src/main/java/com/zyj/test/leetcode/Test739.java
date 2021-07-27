package com.zyj.test.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhongyj
 * @since 2021-04-15 13:17
 */
public class Test739 {
    public static void main(String[] args) {
        int[] temps = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
        new Test739().dailyTemperatures(temps);
    }

    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] result = new int[len];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!queue.isEmpty() && T[i] >= T[queue.peek()]) {
                queue.pop();
            }
            if (queue.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = queue.peek() - i;
            }
            queue.push(i);
        }
        return result;
    }
}
