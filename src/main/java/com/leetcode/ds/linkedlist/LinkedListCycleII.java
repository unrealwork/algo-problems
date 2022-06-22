package com.leetcode.ds.linkedlist;

import com.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slowIterator = head;
        ListNode fastIterator = head;
        do {
            slowIterator = slowIterator.next;
            if (slowIterator == null) {
                return null;
            }
            fastIterator = iterateFast(fastIterator);
            if (fastIterator == null) {
                return null;
            }
        } while (slowIterator != fastIterator);
        return findCycleStart(head, slowIterator);
    }

    private static ListNode findCycleStart(ListNode head, ListNode cycleEl) {
        Set<ListNode> cycleNodes = new HashSet<>();
        ListNode it = cycleEl;
        while (it.next != cycleEl) {
            cycleNodes.add(it);
        }
        it = head;
        while (!cycleNodes.contains(it)) {
            it = it.next;
        }
        return it;
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
