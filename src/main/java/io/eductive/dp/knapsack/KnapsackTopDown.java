package io.eductive.dp.knapsack;

import java.util.function.IntSupplier;

class KnapsackTopDown {

  public static void main(String[] args) {
    KnapsackTopDown ks = new KnapsackTopDown();
    int[] profits = {1, 6, 10, 16};
    int[] weights = {1, 2, 3, 5};
    int maxProfit = ks.solveKnapsack(profits, weights, 7);
    System.out.println("Total knapsack profit ---> " + maxProfit);
    maxProfit = ks.solveKnapsack(profits, weights, 6);
    System.out.println("Total knapsack profit ---> " + maxProfit);
  }

  public int solveKnapsack(int[] profits, int[] weights, int capacity) {
    return new Solver(profits, weights, capacity).solve();
  }

  private static class Solver {
    private final int[] profits;
    private final int[] weights;
    private final int capacity;
    private final int[][] memo;

    private Solver(int[] profits, int[] weights, int capacity) {
      this.profits = profits;
      this.weights = weights;
      this.capacity = capacity;
      this.memo = new int[weights.length + 1][capacity + 1];
    }

    int solve() {
      int res = 0;
      for (int initItem = 0; initItem < weights.length; initItem++) {
        int solution = solveRecursive(0, 0, initItem);
        if (solution > res) {
          res = solution;
        }
      }
      return res;
    }

    private int memoize(int itemIndex, int capacity, IntSupplier resultSupplier) {
      if (memo[itemIndex][capacity] == 0) {
        memo[itemIndex][capacity] = resultSupplier.getAsInt();
      }
      return memo[itemIndex][capacity];
    }

    private int solveRecursive(int profit, int sum, int itemIndex) {
      return memoize(
          itemIndex,
          sum,
          () -> {
            final int nextSum = sum + weights[itemIndex];
            if (nextSum > capacity) {
              return profit;
            } else {
              int res = profit + profits[itemIndex];
              for (int i = itemIndex + 1; i < weights.length; i++) {
                final int next = solveRecursive(profit + profits[itemIndex], nextSum, i);
                if (next > res) {
                  res = next;
                }
              }
              return res;
            }
          });
    }
  }
}
