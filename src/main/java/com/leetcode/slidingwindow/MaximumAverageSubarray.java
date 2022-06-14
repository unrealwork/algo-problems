package com.leetcode.slidingwindow;

class MaximumAverageSubarray {
    private MaximumAverageSubarray() {
    }

    public static double findMaxAverage(int[] nums, int k) {
        long sum = 0L;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        long max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += (nums[i] - nums[i - k]);
            max = Math.max(max, sum);
        }
        return max / (double) k;
    }
}
