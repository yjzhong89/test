package com.zyj.test;

/**
 * @author zhongyj
 * @since 2021-03-18 13:28
 */
public class Test11 {

    public static void main(String[] args) {
        int[] height = new int[] {1,6,8,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
