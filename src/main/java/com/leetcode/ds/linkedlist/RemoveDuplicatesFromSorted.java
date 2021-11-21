package com.leetcode.ds.linkedlist;

import com.leetcode.ListNode;

public class RemoveDuplicatesFromSorted {
  private RemoveDuplicatesFromSorted() {}

  public ListNode deleteDuplicates(ListNode head) {
    ListNode it = head;
    while (it != null) {
      if (it.next != null && it.val == it.next.val) {
        it.next = it.next.next;
      } else {
        it = it.next;
      }
    }
    return head;
  }
}
