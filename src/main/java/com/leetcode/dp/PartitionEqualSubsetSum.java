package com.leetcode.dp;

public class PartitionEqualSubsetSum {
  public static boolean canPartition(int[] nums) {
    return new Solver(nums).solve();
  }

  private static class Solver {
    private final int[] nums;

    private Solver(int[] nums) {
      this.nums = nums;
    }

    private static int sum(int[] nums) {
      int sum = 0;
      for (int num : nums) {
        sum += num;
      }
      return sum;
    }

    boolean solve() {
      int sum = sum(nums);
      if (sum % 2 != 0) {
        return false;
      }
      int target = sum / 2;
      int[] dp = new int[target + 1];
      for (int i = 0; i < nums.length; i++) {
        for (int j = target; j >= 1; j--) {
          if (i == 0) {
            dp[j] = nums[i] <= j ? nums[i] : 0;
          } else {
            if (nums[i] <= j) {
              dp[j] = Math.max(dp[j - nums[i]] + nums[i], dp[j]);
            }
          }
        }
      }
      return dp[target] == target;
    }
  }
}
