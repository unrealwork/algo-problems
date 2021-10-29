package com.leetcode.math;

public class PalindromeNumber {
  private PalindromeNumber() {}

  public static boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    if (x < 10) {
      return true;
    }
    int divider = 10;
    int left;
    while (true) {
      left = x / divider;
      if (left / divider < 10) {
        break;
      }
      divider *= 10;
    }
    int right = x % divider;
    if (left / divider > 0) {
      left = left / 10;
    }
    return reversed(left) == right;
  }

  static int reversed(int a) {
    int res = 0;
    int r = a;
    while (r > 0) {
      res = res * 10 + r % 10;
      r /= 10;
    }
    return res;
  }
}
