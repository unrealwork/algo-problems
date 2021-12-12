package com.leetcode.ds.linkedlist;

import com.leetcode.ListNode;

public class LinkedListCycle {
    private LinkedListCycle() {
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slowIterator = head;
        ListNode fastIterator = head;
        do {
            slowIterator = slowIterator.next;
            if (slowIterator == null) {
                return false;
            }
            fastIterator = iterateFast(fastIterator);
            if (fastIterator == null) {
                return false;
            }
        } while (slowIterator != fastIterator);
        return true;
    }

    private static ListNode iterateFast(ListNode fastIterator) {
        ListNode it = fastIterator;
        if (it == null) {
            return null;
        }
        it = it.next;
        if (it == null) {
            return null;
        }
        return it.next;
    }
}
