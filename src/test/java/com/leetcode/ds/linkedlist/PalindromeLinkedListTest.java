package com.leetcode.ds.linkedlist;

import com.leetcode.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class PalindromeLinkedListTest {

  private static ListNode listOf(int... values) {
    ListNode res = new ListNode(values[0]);
    ListNode last = res;
    for (int i = 1; i < values.length; i++) {
      last.next = new ListNode(values[i]);
      last = last.next;
    }
    return res;
  }

  private static ListNode listOf() {
    return null;
  }

  @Test
  public void testIsPalindrome() {
    Assert.assertTrue(PalindromeLinkedList.isPalindrome(listOf(1, 2, 2, 1)));
  }

  @Test
  public void testIsPalindrome1() {
    Assert.assertTrue(PalindromeLinkedList.isPalindrome(listOf(1, 2, 3, 2, 1)));
  }

  @Test
  public void testIsPalindrome2() {
    Assert.assertFalse(PalindromeLinkedList.isPalindrome(listOf(1, 2)));
  }

  @Test
  public void testIsPalindrome3() {
    Assert.assertTrue(PalindromeLinkedList.isPalindrome(listOf()));
  }
}
