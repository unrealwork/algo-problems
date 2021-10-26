package com.leetcode.dp;

public class HouseRobberIIBottomUp {
  private HouseRobberIIBottomUp() {}

  public static int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
  }

  private static int rob(int[] nums, int start, int end) {
    final int length = end - start;
    if (length < 3) {
      return (length == 1) ? nums[start] : Math.max(nums[start], nums[start + 1]);
    }
    int[] dp = new int[length + 1];
    dp[0] = nums[start];
    dp[1] = Math.max(nums[start], nums[start + 1]);
    for (int i = 2; i < length; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i + start]);
    }
    return dp[length - 1];
  }
}
