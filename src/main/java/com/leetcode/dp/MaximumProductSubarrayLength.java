package com.leetcode.dp;

public class MaximumProductSubarrayLength {
  private MaximumProductSubarrayLength() {}

  public static int getMaxLen(int[] nums) {

    IterationResult it =
        new IterationResult(nums[0] == 0 ? 0 : 1, nums[0] < 0 ? 0 : null, nums[0] > 0);
    int max = it.isProducPositive ? it.length : 0;
    for (int i = 1; i < nums.length; i++) {
      it = it.next(nums, i);
      if (it.bestPositive() > max) {
        max = it.bestPositive();
      }
    }
    return max;
  }

  private static class IterationResult {
    private final int length;
    private final Integer minNegative;
    private final boolean isProducPositive;

    private IterationResult(int length, Integer minNegative, boolean totalProduct) {
      this.length = length;
      this.minNegative = minNegative;
      this.isProducPositive = totalProduct;
    }

    IterationResult next(int[] nums, int i) {
      int cur = nums[i];
      final boolean nextTotalProduct =
          (i > 0 && nums[i - 1] == 0) ? cur > 0 : isProducPositive == cur > 0;
      if (cur > 0) {
        return new IterationResult(length + 1, minNegative, nextTotalProduct);
      }

      if (cur == 0) {
        return new IterationResult(0, null, nextTotalProduct);
      }
      return new IterationResult(
          length + 1, minNegative != null ? minNegative : length, nextTotalProduct);
    }

    public int bestPositive() {
      if (length > 0) {
        if (isProducPositive) {
          return length;
        } else {
          if (minNegative != null) {
            return length - minNegative - 1;
          }
        }
      }
      return 0;
    }
  }
}
