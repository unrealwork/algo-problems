package com.leetcode.dp;

public class MinCostClimbingStairs {
  public static int minCostClimbingStairs(int[] cost) {
    if (cost.length == 2) {
      return Math.min(cost[0], cost[1]);
    }
    int p1 = cost[0];
    int p2 = cost[1];
    for (int i = 2; i < cost.length; i++) {

      int pi = Math.min(p1 + cost[i], p2 + cost[i]);
      if (i == cost.length - 1) {
        pi = Math.min(pi, p2);
      }
      p1 = p2;
      p2 = pi;
    }
    return p2;
  }
}
