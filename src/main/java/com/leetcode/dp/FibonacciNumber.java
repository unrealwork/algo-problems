package com.leetcode.dp;

public class FibonacciNumber {
  public static int fib(int n) {
    if (n < 2) {
      return n;
    } else {
      int p = 1;
      int pp = 0;
      for (int i = 1; i < n; i++) {
        int pi = p + pp;
        pp = p;
        p = pi;
      }
      return p;
    }
  }
}
