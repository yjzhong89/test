package com.zyj.test;

import java.util.*;

/**
 * @author zhongyj
 * @since 2021-03-25 10:15
 */
public class Test23 {
//    public static void main(String[] args) {
//        List<List<Integer>> originList = new ArrayList<>();
//        List<Integer> l1 = Arrays.asList(1, 3, 4, 6);
//        List<Integer> l2 = Arrays.asList(2, 3, 5, 6, 7);
//        List<Integer> l3 = Arrays.asList(3, 8, 9, 10);
//        originList.add(l1);
//        originList.add(l2);
//        originList.add(l3);
//        Test23 test23 = new Test23();
//        List<Integer> result = test23.mergeTwoList(originList);
//        result.forEach(System.out::println);
//
//    }
//
//    public List<Integer> mergeTwoList(List<List<Integer>> originList) {
//        List<Integer> temp = new ArrayList<>();
//        for (int i = 0; i < originList.size(); i++) {
//            List<Integer> result = new ArrayList<>();
//            temp = mergeTwoList(temp, originList.get(i), 0, 0, result);
//        }
//        System.out.println(temp.size());
//        return temp;
//    }
//
//    private List<Integer> mergeTwoList(List<Integer> l1, List<Integer> l2, int i, int j, List<Integer> result) {
//        if (i == l1.size()) {
//            while (j < l2.size()) {
//                result.add(l2.get(j));
//                j++;
//            }
//            return result;
//        } else if (j == l2.size()) {
//            while (i < l1.size()) {
//                result.add(l1.get(i));
//                i++;
//            }
//            return result;
//        } else if (l1.get(i) > l2.get(j)) {
//            result.add(l2.get(j));
//            mergeTwoList(l1, l2, i, j + 1, result);
//            return result;
//        } else {
//            result.add(l1.get(i));
//            mergeTwoList(l1, l2, i + 1, j, result);
//            return result;
//        }
//    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);

        listNode1.next = listNode4;
        listNode4.next = listNode6;
        listNode2.next = listNode5;
        listNode3.next = listNode7;

        ListNode[] lists = new ListNode[] {listNode1, listNode2, listNode3};
        new Test23().mergeKLists(lists);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (int i = 0; i < lists.length; i++) {
            heap.offer(lists[i]);
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (!heap.isEmpty()) {
            ListNode top = heap.poll();
            cur.next = top;
            cur = cur.next;
            if (top.next!= null) {
                heap.offer(top.next);
            }
        }
        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
