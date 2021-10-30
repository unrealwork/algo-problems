package com.leetcode.ds.linkedlist;

import com.leetcode.ListNode;

public class MergeTwoSorted {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode res = null;
    ListNode it1 = l1;
    ListNode it2 = l2;
    ListNode last = null;
    while (it1 != null && it2 != null) {
      ListNode newNode;
      if (it1.val < it2.val) {
        newNode = new ListNode(it1.val);
        it1 = it1.next;
      } else {
        newNode = new ListNode(it2.val);
        it2 = it2.next;
      }
      if (last == null) {
        last = newNode;
        res = newNode;
      } else {
        last.next = newNode;
        last = newNode;
      }
    }

    if (it1 != null) {
      if (last != null) {
        last.next = it1;
      } else {
        res = it1;
      }
    }

    if (it2 != null) {
      if (last != null) {
        last.next = it2;
      } else {
        res = it2;
      }
    }
    return res;
  }
}
