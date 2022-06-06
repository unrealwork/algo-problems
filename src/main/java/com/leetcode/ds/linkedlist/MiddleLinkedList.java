package com.leetcode.ds.linkedlist;

import com.leetcode.ListNode;

final class MiddleLinkedList {
    private MiddleLinkedList() {

    }

    public static ListNode middleNode(ListNode head) {
        int size = size(head);
        int middle = size / 2 + 1;
        ListNode it = head;
        for (int i = 0; i < middle && it != null; i++) {
            it = it.next;
        }
        return it;
    }

    private static int size(ListNode head) {
        if (head == null) {
            return 0;
        } else {
            ListNode it = head;
            int size = 0;
            while (it != null) {
                size++;
                it = it.next;
            }
            return size;
        }
    }
}
