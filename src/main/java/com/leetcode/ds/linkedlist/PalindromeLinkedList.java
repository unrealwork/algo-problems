package com.leetcode.ds.linkedlist;

import com.leetcode.ListNode;

public class PalindromeLinkedList {
  private PalindromeLinkedList() {}

  public static boolean isPalindrome(ListNode head) {
    int n = size(head);
    if (n < 2) {
      return true;
    }
    ListNode it1 = head;
    ListNode it2 = secondHalfReversed(head, n);
    if (it2 == null) {
      throw new IllegalStateException("Incorrect Second Half");
    }
    for (int i = 0; i < n / 2; i++) {
      if (it1.val != it2.val) {
        return false;
      }
      it1 = it1.next;
      it2 = it2.next;
    }
    return true;
  }

  private static int size(ListNode head) {
    int r = 0;
    ListNode it = head;
    while (it != null) {
      r++;
      it = it.next;
    }
    return r;
  }

  private static ListNode secondHalfReversed(ListNode head, int n) {
    if (head == null) {
      throw new IllegalStateException("Incorrect Second Half");
    }
    int mid = n % 2 == 0 ? n / 2 : n / 2 + 1;
    ListNode it = head;
    int i = 0;
    while (i < mid) {
      it = it.next;
      i++;
    }
    return reverseList(it);
  }

  private static ListNode reverseList(ListNode head) {
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
