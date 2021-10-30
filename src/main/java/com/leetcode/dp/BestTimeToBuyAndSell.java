package com.leetcode.dp;

public class BestTimeToBuyAndSell {
  private BestTimeToBuyAndSell() {}

  public static int maxProfit(int[] prices) {
    Iteration it = new Iteration(prices[0], 0);
    for (int i = 1; i < prices.length; i++) {
      it = it.next(prices[i]);
    }
    return it.getProfit();
  }

  private static class Iteration {
    private final int min;
    private final int profit;

    private Iteration(int min, int profit) {
      this.min = min;
      this.profit = profit;
    }

    public Iteration next(int curValue) {
      int nextMin = Math.min(curValue, min);
      if (curValue - nextMin > profit) {
        return new Iteration(nextMin, curValue - nextMin);
      } else {
        return new Iteration(nextMin, profit);
      }
    }

    public int getProfit() {
      return profit;
    }
  }
}
