package com.leetcode.dp;

public class JumpGameII {
  private JumpGameII() {}

  public static int jump(int[] nums) {
    int[] dp = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      final int limit = Math.min(i + nums[i] + 1, nums.length);
      for (int j = i + 1; j < limit; j++) {
        dp[j] = dp[j] > 0 ? Math.min(dp[i] + 1, dp[j]) : dp[i] + 1;
      }
    }
    return dp[nums.length - 1];
  }
}
