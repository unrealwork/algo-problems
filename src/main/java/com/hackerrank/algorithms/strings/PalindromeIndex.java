package com.hackerrank.algorithms.strings;

import java.util.Scanner;

public class PalindromeIndex {

  static int palindromeIndex(String s) {
    int left = 0;
    int right = 0;
    int len = s.length();
    int mid = len / 2;
    for (int i = 0; i < mid; i++) {
      left += s.charAt(i);
      right += s.charAt(len - i - 1);
    }
    if (left == right) {
      return -1;
    }
    if (len % 2 == 0) {
      for (int i = 0; i < len; i++) {
        if (i < mid) {
          if (left - s.charAt(i) == right - s.charAt(mid)) {
            return i;
          }
        } else {
          if (left - s.charAt(mid - 1) == right - s.charAt(i)) {
            return i;
          }
        }
      }
    } else {
      for (int i = 0; i < len; i++) {
        if (i < mid) {
          if (left - s.charAt(i) + s.charAt(mid) == right) {
            return i;
          }
        } else {
          if (left == right - s.charAt(i) + s.charAt(mid)) {
            return i;
          }
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      String s = in.next();
      int result = palindromeIndex(s);
      System.out.println(result);
    }
  }
}
