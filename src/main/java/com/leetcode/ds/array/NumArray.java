package com.leetcode.ds.array;

class NumArray {

    private final int[] p;

    public NumArray(int[] nums) {
        p = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                p[i] = nums[i];
            } else {
                p[i] = p[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return p[right];
        } else {
            return p[right] - p[left - 1];
        }
    }
}
