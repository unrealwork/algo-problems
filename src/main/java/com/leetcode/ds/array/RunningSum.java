package com.leetcode.ds.array;

/**
 * @author unrealwork
 */
public class RunningSum {
    private RunningSum() {

    }

    public static int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        return res;
    }
}
