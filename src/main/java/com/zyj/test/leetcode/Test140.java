package com.zyj.test.leetcode;

import java.util.*;

/**
 * @author zhongyj
 * @since 2021-04-19 15:56
 */
public class Test140 {
    public static void main(String[] args) {
        System.out.println(new Test140().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }

    List<String> result = new ArrayList<>();
    List<String> temp = new ArrayList();
    Boolean[] memo;

    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        memo = new Boolean[n + 1];
        dfs(s, n, new HashSet<>(wordDict));
        return result;
    }

    private boolean dfs(String s, int len, Set<String> dict) {
        if (len == 0) {
            result.add(mergeList(temp));
            temp.clear();
            return true;
        }

        memo[len] = false;
        for (int i = 0; i < len; i++) {
            String rightStr = s.substring(i, len);
            boolean right = dict.contains(rightStr);
            if (!right) {
                continue;
            }
            temp.add(rightStr);
            boolean left = dfs(s, i, dict);
            if (left) {
                memo[len] = true;
            }
        }
        return memo[len];
    }

    private String mergeList(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(list.size() - 1 - i));
            if (i != list.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
