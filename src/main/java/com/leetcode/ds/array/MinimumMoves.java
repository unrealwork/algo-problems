package com.leetcode.ds.array;

import java.util.Arrays;

public class MinimumMoves {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        int median = nums.length % 2 != 0 ? nums[mid]: (nums[mid] + nums[mid-1])/2;
        int res = 0;
        for (int num : nums) {
            res += Math.abs(median - num);
        }
        return res;
    }
}
