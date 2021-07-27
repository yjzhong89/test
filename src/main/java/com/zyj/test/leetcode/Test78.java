package com.zyj.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongyj
 * @since 2021-04-06 17:56
 */
public class Test78 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 4};
        Test78 test78 = new Test78();
        test78.subset1(nums);
    }

    public void subset(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        int len = nums.length;
        for (int i = 0; i < (1 << len); i++) {
            temp.clear();
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) {
                    temp.add(nums[j]);
                }
            }
            result.add(new ArrayList<>(temp));
        }
    }

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subset1(int[] nums) {
        dfs(0, nums);
        return result;
    }

    public void dfs(int current, int[] nums) {
        if (current == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[current]);
        dfs(current + 1, nums);
        temp.remove(temp.size() - 1);
        dfs(current + 1, nums);
    }
}
