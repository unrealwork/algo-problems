package com.leetcode.math;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeNumberTest {

  @Test
  public void testIsPalindrome() {
    assertFalse(PalindromeNumber.isPalindrome(-101));
  }

  @Test
  public void testIsPalindrome1() {
    assertTrue(PalindromeNumber.isPalindrome(121));
  }

  @Test
  public void testIsPalindrome2() {
    assertFalse(PalindromeNumber.isPalindrome(10));
  }

  @Test
  public void testIsPalindrome3() {
    assertTrue(PalindromeNumber.isPalindrome(0));
  }
}
