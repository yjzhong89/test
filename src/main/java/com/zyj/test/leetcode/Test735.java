package com.zyj.test.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhongyj
 * @since 2021-04-15 13:32
 */
public class Test735 {
    public static void main(String[] args) {
        int[] list = new int[]{5, 10, -5};
        new Test735().asteroidCollision(list);
    }

    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
                continue;
            }
            if (asteroids[i] >= 0) {
                stack.push(asteroids[i]);
            } else {
                if (stack.peek() <= 0) {
                    stack.push(asteroids[i]);
                } else {
                    while (!stack.isEmpty()) {
                        if (stack.peek() > 0 && stack.peek() + asteroids[i] < 0) {
                            stack.pop();
                        } else {
                            break;
                        }
                    }
                    if (stack.isEmpty()) {
                        stack.push(asteroids[i]);
                    } else if (stack.peek() + asteroids[i] == 0) {
                        stack.pop();
                    } else if (stack.peek() < 0) {
                        stack.push(asteroids[i]);
                    }
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
