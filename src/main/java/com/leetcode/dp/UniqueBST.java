package com.leetcode.dp;

public class UniqueBST {
  private UniqueBST() {}

  public static int numTrees(int n) {
    if (n < 3) {
      return n;
    }
    int p = 1;
    for (int i = 1; i <= n; i++) {
      p = (2 * (2 * i - 1) * p) / (i + 1);
    }
    return p;
  }
}
