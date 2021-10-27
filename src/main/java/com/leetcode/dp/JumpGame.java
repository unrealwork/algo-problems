package com.leetcode.dp;

public class JumpGame {
  private JumpGame() {}

  public static boolean canJump(int[] nums) {
    boolean[] dp = new boolean[nums.length];
    dp[0] = true;
    for (int i = 0; i < nums.length; i++) {
      if (dp[i]) {
        final int limit = Math.min(i + nums[i] + 1, nums.length);
        for (int j = i; j < limit; j++) {
          dp[j] = true;
        }
      }
    }
    return dp[nums.length - 1];
  }
}
