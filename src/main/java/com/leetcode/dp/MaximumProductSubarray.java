package com.leetcode.dp;

public class MaximumProductSubarray {
  private MaximumProductSubarray() {}

  public static int maxProduct(int[] nums) {

    IterationResult it = new IterationResult(nums[0], nums[0] < 0 ? nums[0] : null, nums[0]);
    int max = it.best;
    for (int i = 1; i < nums.length; i++) {
      it = it.next(nums[i]);
      if (it.best > max) {
        max = it.best;
      }
    }
    return max;
  }

  private static class IterationResult {
    private final int best;
    private final Integer minNegative;
    private final int totalProduct;

    private IterationResult(int best, Integer minNegative, int totalProduct) {
      this.best = best;
      this.minNegative = minNegative;
      this.totalProduct = totalProduct;
    }

    IterationResult next(int cur) {
      final int nextTotalProduct = (totalProduct == 0) ? cur : totalProduct * cur;
      if (cur > 0) {
        return new IterationResult(Math.max(cur * best, cur), minNegative, nextTotalProduct);
      }

      if (cur == 0) {
        return new IterationResult(0, null, 0);
      }

      final int nextBest;
      Integer nextMinNegative = minNegative;
      if (nextTotalProduct >= 0) {
        nextBest = nextTotalProduct;
      } else {
        nextBest = (minNegative == null) ? cur : best / minNegative * cur;
        if (minNegative == null) {
          nextMinNegative = nextTotalProduct;
        }
      }
      return new IterationResult(nextBest, nextMinNegative, nextTotalProduct);
    }
  }
}
