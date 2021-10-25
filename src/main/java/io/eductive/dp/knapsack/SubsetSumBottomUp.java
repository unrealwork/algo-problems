package io.eductive.dp.knapsack;

public class SubsetSumBottomUp {
  static boolean canPartition(int[] num, int sum) {
    return new Solver(num, sum).solve();
  }

  private static class Solver {
    private final int[] nums;
    private final int target;

    private Solver(int[] nums, int target) {
      this.nums = nums;
      this.target = target;
    }

    boolean solve() {
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
