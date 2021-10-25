package com.leetcode.dp;

public class ClimbingStairs {
  public static int climbStairs(int n) {
    if (n < 2) {
      return n;
    }
    int p1 = 1;
    int p2 = 2;
    for (int i = 3; i < n + 1; i++) {
      int pi = p1 + p2;
      p1 = p2;
      p2 = pi;
    }
    return p2;
  }
}
