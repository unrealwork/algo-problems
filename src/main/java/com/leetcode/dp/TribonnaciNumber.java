package com.leetcode.dp;

public class TribonnaciNumber {
  public static int tribonacci(int n) {
    if (n < 3) {
      return n == 0 ? 0 : 1;
    }
    int t0 = 0;
    int t1 = 1;
    int t2 = 1;
    for (int i = 2; i < n; i++) {
      int ti = t0 + t1 + t2;
      t0 = t1;
      t1 = t2;
      t2 = ti;
    }
    return t2;
  }
}
