package io.eductive.dp.knapsack;

import static java.lang.Math.max;

public class KnapsackBottomUp {
  public static void main(String[] args) {
    KnapsackBottomUp ks = new KnapsackBottomUp();
    int[] profits = {1, 6, 10, 16};
    int[] weights = {1, 2, 3, 5};
    int maxProfit = ks.solveKnapsack(profits, weights, 7);
    System.out.println("Total knapsack profit ---> " + maxProfit);
    maxProfit = ks.solveKnapsack(profits, weights, 6);
    System.out.println("Total knapsack profit ---> " + maxProfit);
  }

  static int solveKnapsack(int[] profits, int[] weights, int capacity) {
    return new Solver(profits, weights, capacity).solve();
  }

  private static class Solver {
    private final int[] profits;
    private final int[] weights;
    private final int capacity;
    private final int[] dp;

    private Solver(int[] profits, int[] weights, int capacity) {
      this.profits = profits;
      this.weights = weights;
      this.capacity = capacity;
      this.dp = new int[capacity + 1];
    }

    int solve() {
      for (int i = 0; i < weights.length; i++) {
        for (int j = capacity; j >= 1; j--) {
          if (i == 0) {
            dp[j] = weights[i] <= j ? profits[i] : 0;
          } else {
            if (weights[i] <= j) {
              dp[j] = max(dp[j - weights[i]] + profits[i], dp[j]);
            }
          }
        }
      }
      return dp[capacity];
    }
  }
}
