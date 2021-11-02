package com.leetcode.ds.linkedlist;

import com.leetcode.ListNode;

public class ReversedList {
  private ReversedList() {}

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode it = head;
    ListNode res = null;
    while (it != null) {
      ListNode clone = it;
      it = it.next;
      clone.next = res;
      res = clone;
    }
    return res;
  }
}
