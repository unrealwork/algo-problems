package com.leetcode.dp;

public class HouseRobberBottomUp {
  private HouseRobberBottomUp() {}

  public static int rob(int[] nums) {
    if (nums.length < 3) {
      return (nums.length == 1) ? nums[0] : Math.max(nums[0], nums[1]);
    }
    int[] dp = new int[nums.length + 1];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[nums.length - 1];
  }
}
