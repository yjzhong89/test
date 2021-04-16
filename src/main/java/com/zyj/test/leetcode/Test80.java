package com.zyj.test;

/**
 * @author zhongyj
 * @since 2021-04-14 13:30
 */
public class Test80 {
    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 4, 4, 5};
        System.out.println(new Test80().removeDuplicates(list));
    }

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        int len = nums.length;

        while (j < len) {
            if (i == 0 || i == 1) {
                nums[i++] = nums[j++];
            } else if ((nums[i - 1] == nums[i - 2]) && (nums[j] == nums[i - 1])) {
                j++;
            } else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        return i;
    }
}
