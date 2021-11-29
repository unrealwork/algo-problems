package com.leetcode.dp;

public class BestTimeToBuyAndSellCooldown {
  private BestTimeToBuyAndSellCooldown() {}

  public static int maxProfit(int[] prices) {
    int[][] dp = new int[prices.length][3];
    dp[0][0] = 0;
    dp[0][1] = prices[0];
    dp[0][1] = prices[0];
    for (int i = 1; i < prices.length; i++) {
      int min = dp[i - 1][1];
      if (i < 3) {
        dp[i][0] = Math.max(prices[i] - dp[i - 1][1], dp[i - 1][0]);
      } else {
        boolean isCoolDown = dp[i - 3][0] != dp[i - 2][0];
        if (isCoolDown) {
          dp[i][0] =
              Math.max(
                  dp[i - 3][0] - dp[i - 1][1] + prices[i], Math.max(prices[i] - min, dp[i - 1][0]));
        } else {
          int curMin = Math.min(dp[i - 2][1], dp[i - 1][1]);
          dp[i][0] =
              Math.max(Math.max(prices[i] - min, dp[i - 1][0]), dp[i - 1][0] - curMin + prices[i]);
        }
      }
      dp[i][1] = Math.min(min, prices[i]);
    }

    return dp[prices.length - 1][0];
  }
}
