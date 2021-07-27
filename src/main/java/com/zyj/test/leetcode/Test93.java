package com.zyj.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongyj
 * @since 2021-04-12 15:07
 */
public class Test93 {
    public static void main(String[] args) {
        Test93 test93 = new Test93();
    }

    public List<String> restoreIpAddresses(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        List<String> finalResult = new ArrayList<>();

        restoreIpAddresses(s, -1, 0, current, result);
        for (int i = 0; i < result.size(); i++) {
            finalResult.add(result.get(i).get(0) + "." + result.get(i).get(1) + "." + result.get(i).get(2) + "." + result.get(i).get(3));
        }
        return finalResult;
    }

    public void restoreIpAddresses(String s, int index, int level, List<String> current, List<List<String>> result) {
        if (level == 4 || index >= s.length() - 1) {
            if (level == 4 && index == s.length() - 1) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = 1; i < 4; i++) {
            String a = s.substring(index + 1, index + i + 1 > s.length() ? s.length() : index + i + 1);
            if (a.equals("0") || (!a.startsWith("0") && Integer.parseInt(a) < 256)) {
                current.add(a);
                restoreIpAddresses(s, index + i, level + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
