package com.leetcode.dp;

public class BestTimeToBuyAndSell {
  private BestTimeToBuyAndSell() {}

  public static int maxProfit(int[] prices) {
    int res = 0;
    int curMin = prices[0];
    for (int i = 1; i < prices.length; i++) {
      res = Math.max(res, prices[i] - curMin);
      if (prices[i] < curMin) {
        curMin = prices[i];
      }
    }
    return res;
  }
}
