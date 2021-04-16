package com.zyj.test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhongyj
 * @since 2021-03-25 19:18
 */
public class Test32 {
    public static void main(String[] args) {
        String s = "))(()()";
        System.out.println(getLongest(s));
    }

    public static int getLongest(String s) {
        int len = s.length();
        int max = 0;
        Deque<Integer> queue = new LinkedList<>();
        queue.push(-1);
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                queue.push(i);
            } else {
                queue.pop();
                if (queue.isEmpty()) {
                    queue.push(i);
                } else {
                    max = Math.max(max, i - queue.peek());
                }
            }
        }
        return max;
    }
}
