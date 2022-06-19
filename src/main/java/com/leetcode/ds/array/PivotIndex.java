package com.leetcode.ds.array;

class PivotIndex {
    private PivotIndex() {
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int left = 0;
        int right = sum - nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (left == right) {
                return i;
            }
            if (i < nums.length - 1) {
                left += nums[i];
                right -= nums[i + 1];
            }
        }
        return -1;
    }
}
