package com.zyj.test;

/**
 * @author zhongyj
 * @since 2021-03-25 15:01
 */
public class Test31 {

    public static void main(String[] args) {
        Test31 test31 = new Test31();
        test31.order(new int[]{1, 2, 3, 4, 6, 5, 3});
    }

    public void order(int[] list) {
        int end = list.length - 1;
        int start = 0;
        boolean find = false;
        for (int j = end; j > 0; j--) {
            // 从后往前找到第一个升序的相邻数对，即list[j - 1] < list[j]
            if (list[j - 1] < list[j]) {
                for (int k = end; k > j - 1; k--) {
                    // 再从后往前找到第一个比nums[j-1]大的数，交换他们
                    if (list[k] > list[j - 1]) {
                        int temp = list[j - 1];
                        list[j - 1] = list[k];
                        list[k] = temp;
                        // 交换的数的下一个位置要保证之后升序
                        start = j;
                        find = true;
                        break;
                    }
                }
            }
            if (find) {
                break;
            }
        }
        while (start <= end) {
            // 刚刚的算法已经保证j-end是降序排列了，把它们弄成升序只需要头尾交换即可
            int temp = list[start];
            list[start] = list[end];
            list[end] = temp;
            start++;
            end--;
        }
    }

    public void orderAsc(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] > list[j]) {
                    int number = list[i];
                    list[i] = list[j];
                    list[j] = number;
                }
            }
        }
    }
}
