package com.zyj.test.leetcode;

/**
 * @author zhongyj
 * @since 2021-03-24 17:32
 */
public class Test21 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        listNode1.next = listNode3;
        listNode3.next = listNode5;

        listNode2.next = listNode4;
        listNode4.next = listNode6;

        ListNode result = mergeTwoList(listNode1, listNode2);
    }

    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val >= l2.val) {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        }
    }
}

class ListNode {
    public ListNode next;
    public int val;

    public ListNode(int val) {
        this.val = val;
    }
}
