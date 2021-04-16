package com.zyj.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhongyj
 * @since 2021-04-13 19:37
 */
public class Test148 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(6);
        ListNode listNode2 = new ListNode(7);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(3);
        ListNode listNode7 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        new Test148().sortList(listNode1);
    }

    public ListNode sortList(ListNode head) {
        List<Integer> tempList = new ArrayList<>();
        while (head != null) {
            tempList.add(head.val);
            head = head.next;
        }
        tempList.sort(Comparator.comparingInt(a -> a));
        ListNode newHead = new ListNode();
        ListNode tempNode = newHead;
        for (int i = 0; i < tempList.size(); i++) {
            ListNode listNode = new ListNode(tempList.get(i));
            newHead.next = listNode;
            newHead = newHead.next;
        }

        return tempNode.next;
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
}
