package com.leetcode.ds.array;

class MinimumOperationsToReduce {
    private MinimumOperationsToReduce() {
        
    }

    public static int minOperations(int[] nums, int x) {
        int slidingWindowSum = 0;
        long sum = sum(nums);
        if (sum < x) {
            return -1;
        }
        int target = (int) (sum - x);
        int windowStart = 0;
        int maxOperationsCount = -1;
        if (slidingWindowSum == target) {
            maxOperationsCount = windowStart;
        }
        for (int windowsEnd = windowStart; windowsEnd < nums.length; windowsEnd++) {
            slidingWindowSum += nums[windowsEnd];
            while (windowStart < nums.length && slidingWindowSum > target) {
                slidingWindowSum -= nums[windowStart];
                windowStart++;
            }
            if (slidingWindowSum == target) {
                maxOperationsCount = Math.max(maxOperationsCount, windowsEnd - windowStart + 1);
            }
        }

        return maxOperationsCount == -1 ? -1 : (nums.length - maxOperationsCount);
    }

    private static long sum(int[] nums) {
        long s = 0;
        for (int num : nums) {
            s += num;
        }
        return s;
    }
}
