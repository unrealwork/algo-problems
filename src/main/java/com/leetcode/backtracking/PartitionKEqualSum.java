package com.leetcode.backtracking;

import java.util.Arrays;

final class PartitionKEqualSum {
    private PartitionKEqualSum() {

    }

    static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int max = nums[0];
        for (int matchstick : nums) {
            sum += matchstick;
            max = Math.max(matchstick, max);
        }
        if (sum % k != 0 || nums.length < k) {
            return false;
        }
        int target = sum / k;
        if (max > target) {
            return false;
        }
        Arrays.sort(nums);
        int lastIndex = nums.length - 1;
        return canPartitionKEqualSumRec(nums, new int[k], target, lastIndex);
    }

    private static boolean canPartitionKEqualSumRec(int[] mathsticks, int[] buckets, int target, int curIndex) {
        if (curIndex < 0) {
            return true;
        }
        for (int i = 0; i < buckets.length; i++) {
            if (i > 0 && buckets[i] == buckets[i - 1]) {
                continue;
            }
            int el = mathsticks[curIndex];
            if (buckets[i] + el <= target) {
                buckets[i] += mathsticks[curIndex];
                if (canPartitionKEqualSumRec(mathsticks, buckets, target, curIndex - 1)) {
                    return true;
                }
                buckets[i] -= mathsticks[curIndex];
            }
        }
        return false;
    }
}
