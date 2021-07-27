package com.zyj.test.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhongyj
 * @since 2021-04-17 13:53
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.println(new Test3().lengthOfLongestSubstring("abcabcdb"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        int start = 0;

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                start = Math.max(start, map.get(chars[i]) + 1);
            }
            map.put(chars[i], i);
            result = Math.max(i - start + 1, result);
        }
        return result;
    }
}
