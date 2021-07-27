package com.zyj.test.leetcode;

import java.util.Scanner;

/**
 * @author zhongyj
 * @since 2021-03-01 9:42
 * Query: { "flowTime" : { "$gte" : { "$date" : 1614096000000 } }, "userCode" : "anonymous" }, Fields: { }, Sort: { }
 * Query: { "$and" : [{ "flowTime" : { "$gte" : { "$date" : 1612022400000 } } }, { "flowTime" : { "$lte" : { "$date" : 1617033600000 } } }], "userCode" : "anonymous" }, Fields: { }, Sort: { }
 */

/**
 * 思路：
 * 1. 如果传入的数不是一个整形，直接提示用户
 * 2. 如果传入的数是在-9到9的范围内，不需要进行操作，直接返回
 * 3. 传入的数在经过反转后可能会超过int的边界，所以在反转时需要使用long类型
 */
public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个数字");
            try {
                int number = scanner.nextInt();
                System.out.println(test2.reverseInt(number));
                break;
            } catch (Exception e) {
                System.out.println("您输入的数字不正确，请检查后重新输入！");
            }
        }
    }

    public long reverseInt(int n) {
        if (n >= -9 && n <= 9) {
            // 如果传入的数在-9到9的范围内，不需要进行操作，直接返回
            return n;
        }

        long result = n;
        int count = 1;

        // 判断传入的整数有几位
        while ((result /= 10) != 0) {
            count++;
        }

        int[] list = new int[count];
        for (int i = 0; i < count; i++) {
            list[i] = n % 10;
            // 将原来最低位的值放到最高位，将原来倒数第二位的值放到第二位，以此类推
            result += list[i] * Math.pow(10, count - 1 - i);
            n = n / 10;
        }

        return result;
    }
}
