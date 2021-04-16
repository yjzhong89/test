package com.zyj.test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhongyj
 * @since 2021-04-15 16:36
 */
public class Test394 {
    public static void main(String[] args) {
        String s = "abc4[ab]2[ef]";
        System.out.println(new Test394().decodeString(s));
    }

    public String decodeString(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] list = s.toCharArray();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == '[') {
                stack.push(list[i]);
            } else if (list[i] == ']') {
                StringBuilder sb = new StringBuilder();
                StringBuilder charSb = new StringBuilder();
                while (stack.peek() != '[') {
                    charSb.append(stack.pop());
                }
                charSb = charSb.reverse();
                stack.pop();
                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    num.append(stack.pop());
                }
                int repeatTime = Integer.parseInt(num.reverse().toString());
                for (int j = 0; j < repeatTime; j++) {
                    sb.append(charSb);
                }

                char[] chars = sb.toString().toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    stack.push(chars[j]);
                }

            } else if (list[i] >= 'a' && list[i] <= 'z') {
                stack.push(list[i]);
            } else {
                stack.push(list[i]);
            }
        }

        StringBuilder stackRemain = new StringBuilder();
        while (!stack.isEmpty()) {
            stackRemain.append(stack.pop());
        }
        return stackRemain.reverse().toString();
    }
}
