package com.zyj.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongyj
 * @since 2021-03-26 15:35
 */
public class Test39 {

    public static void main(String[] args) {
        Test39 test39 = new Test39();
        int[] list = new int[]{2, 3, 5, 8};
        int target = 8;
        System.out.println(test39.getAllGroup(list, target));
    }

    public List<List<Integer>> getAllGroup(int[] list, int target) {
        List<List<Integer>> allResult = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        getAll(list, target, allResult, result, 0);

        return allResult;
    }

    //    private void getAll(int[] list, int target, List<List<Integer>> allResult, List<Integer> result, int left) {
//        if (left == list.length) {
//            return;
//        }
//        if (target == 0) {
//            allResult.add(new ArrayList<>(result));
//            return;
//        }
//        getAll(list, target, allResult, result, left + 1);
//        if (target - list[left] >= 0) {
//            result.add(list[left]);
//            getAll(list, target - list[left], allResult, result, left);
//            result.remove(result.size() - 1);
//        }
//    }

    private void getAll(int[] list, int target, List<List<Integer>> allResult, List<Integer> result, int left) {
        if (target == 0) {
            allResult.add(new ArrayList<>(result));
            return;
        }

        for (int i = left; i < list.length; i++) {
            if (target - list[i] >= 0) {
                result.add(list[i]);
                getAll(list, target - list[i], allResult, result, i);
                result.remove(result.size() - 1);
            }
        }
    }
}
