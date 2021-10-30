package com.leetcode.dp;

public class BestTimeToBuyAndSellII {
  private BestTimeToBuyAndSellII() {}

  public static int maxProfit(int[] prices) {
    Iteration it = new Iteration(prices[0], prices[0], 0);
    for (int i = 1; i < prices.length; i++) {
      it = it.next(prices[i]);
    }
    return it.getProfit();
  }

  private static class Iteration {
    private final int min;
    private final int curMin;
    private final int profit;

    private Iteration(int min, int curMin, int profit) {
      this.min = min;
      this.curMin = curMin;
      this.profit = profit;
    }

    public Iteration next(int curValue) {
      int nextMin = Math.min(curValue, min);
      int nextCurMin = Math.min(curValue, curMin);
      final int nextBuyProfit = profit + curValue - nextCurMin;
      final int bestBuyProfit = curValue - nextMin;
      if (nextBuyProfit > bestBuyProfit && nextBuyProfit > profit) {
        return new Iteration(nextMin, curValue, nextBuyProfit);
      } else {
        if (bestBuyProfit > profit) {
          return new Iteration(nextMin, curValue, bestBuyProfit);
        } else {
          return new Iteration(nextMin, nextCurMin, profit);
        }
      }
    }

    public int getProfit() {
      return profit;
    }
  }
}
