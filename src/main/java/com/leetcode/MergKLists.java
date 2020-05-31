package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists);
    }
    
    
    public static ListNode merge(ListNode[] results) {
        ListNode result = null;
        ListNode lastAdded = null;
        final PriorityQueue<ListNode> minHeap = initialHeap(results);
     
        while (!minHeap.isEmpty()) {
            final ListNode min = minHeap.remove();
            if (min != null) {
                if (result == null) {
                    result = new ListNode(min.val);
                    lastAdded = result;
                } else {
                    lastAdded.next = new ListNode(min.val);
                    lastAdded = lastAdded.next;
                }
                if (min.next != null) {
                    minHeap.add(min.next);
                }
            }
        }
        return result;
    }

    private static PriorityQueue<ListNode> initialHeap(ListNode[] nodes) {
        final PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });
        for (ListNode node : nodes) {
            if (node != null) {
                minHeap.add(node);
            }
        }
        return minHeap;
    }
}
