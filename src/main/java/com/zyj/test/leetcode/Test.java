package com.zyj.test;

import java.util.PriorityQueue;

/**
 * @author zhongyj
 * @since 2021-04-13 13:25
 */
public class Test {
    public static void main(String[] args) {
//        int[] list = new int[]{1, 2, 3, 4, 5};
//        int target = 90;
//        System.out.println(new Test().targetSum(list, target));

//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        System.out.println(new Test().reverseList(listNode1));

        int[] list = new int[]{1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5};
        System.out.println(new Test().findKthLargest(list, 3));
    }

    public boolean targetSum(int[] list, int target) {
        if (list.length == 1) {
            return list[0] == target;
        }
        boolean[][] temp = new boolean[list.length][target + 1];
        for (int i = 0; i < list.length; i++) {
            temp[i][0] = true;
        }
        for (int i = 0; i < target + 1; i++) {
            temp[0][i] = false;
        }
        if (list[0] <= target) {
            temp[0][list[0]] = true;
        }

        for (int i = 1; i < list.length; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (list[i] > j) {
                    temp[i][j] = temp[i - 1][j];
                } else {
                    boolean a = temp[i - 1][j - list[i]];
                    boolean b = temp[i - 1][j];
                    temp[i][j] = a || b;
                }
            }
        }
        return temp[list.length - 1][target];
    }

    public ListNode reverseList(ListNode head) {
        ListNode curHead = head;
        ListNode pre = null;
        ListNode next = null;
        while (curHead != null) {
            next = curHead.next;
            curHead.next = pre;
            pre = curHead;
            curHead = next;
        }
        return pre;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int findKthLargest(int[] list, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < list.length; i++) {
            if (heap.size() < k || heap.peek() <= list[i]) {
                heap.offer(list[i]);
            }
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}
