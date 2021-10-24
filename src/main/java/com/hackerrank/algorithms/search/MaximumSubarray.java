package com.hackerrank.algorithms.search;

import java.util.List;

public class MaximumSubarray {
  private MaximumSubarray() {}

  public static long maximumSum(List<Long> a, long m) {
    // Write your code here
    long[][] dp = new long[a.size()][a.size()];
    long res = 0;
    int i = 0;
    for (Long n : a) {
      for (int j = i; j >= 0; j--) {
        final int len = i - j;
        if (len > 0) {
          dp[i][len] = (dp[i][len - 1] + n) % m;
        } else {
          dp[i][len] = n % m;
        }
        if (dp[i][i - j] > res) {
          res = dp[i][i - j];
        }
      }
      i++;
    }
    return res;
  }
}
