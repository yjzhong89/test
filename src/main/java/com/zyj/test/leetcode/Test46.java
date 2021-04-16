package com.zyj.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongyj
 * @since 2021-03-27 15:56
 */
public class Test46 {
    public static void main(String[] args) {
        Test46 test46 = new Test46();
        int[] list = new int[]{1, 2, 3};
        test46.getAllArrangement(list);
    }

    public List<List<Integer>> getAllArrangement(int[] list) {
        List<List<Integer>> allResult = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        getAllArrangement(list, 0, allResult, result);
        return allResult;
    }

    private void getAllArrangement(int[] list, int index, List<List<Integer>> allResult, List<Integer> result) {
        if (result.size() == list.length) {
            allResult.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < list.length; i++) {
            if (result.contains(list[i])) {
                continue;
            }
            result.add(list[i]);
            getAllArrangement(list, i, allResult, result);
            result.remove(result.size() - 1);
        }
    }
}
