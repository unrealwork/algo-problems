package io.eductive.slidingwindow;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <br>
 * A subarray is a contiguous part of an array.
 * <br>
 * <a href="https://leetcode.com/problems/maximum-subarray/">Maximum Subarray</a>
 *
 * @author unrealwork
 */
final class MaximumSubarraySum {
    private MaximumSubarraySum() {
        
    }

    public static int findMaxSumSubArray(int k, int[] arr) {
        if (k > arr.length) {
            return -1;
        }
        int curSum = 0;
        for (int i = 0; i < k; i++) {
            curSum += arr[i];
        }
        int max = curSum;
        for (int i = k; i < arr.length; i++) {
            curSum += (arr[i] - arr[i - k]);
            if (curSum > max) {
                max = curSum;
            }
        }
        return max;
    }
}
