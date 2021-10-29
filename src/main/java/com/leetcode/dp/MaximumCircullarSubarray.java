package com.leetcode.dp;

public class MaximumCircullarSubarray {
  private MaximumCircullarSubarray() {}

  public static int maxSubarraySumCircular(int[] nums) {
    int pMax = nums[0];
    int pMin = nums[0];
    int max = pMax;
    int min = pMin;
    int totalSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      totalSum += nums[i];
      pMax = Math.max(pMax + nums[i], nums[i]);
      pMin = Math.min(pMin + nums[i], nums[i]);
      if (pMax > max) {
        max = pMax;
      }
      if (pMin < min) {
        min = pMin;
      }
    }
    if (max < 0) return max;
    return Math.max(max, totalSum - min);
  }
}
