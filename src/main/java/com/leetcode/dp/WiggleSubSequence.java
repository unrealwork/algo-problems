package com.leetcode.dp;

class WiggleSubSequence {
    private WiggleSubSequence() {

    }

    public static int wiggleMaxLength(int[] nums) {
        int res = 1;
        Boolean prevAsc = null;
        for (int i = 1; i < nums.length; i++) {
            if (prevAsc == null) {
                if (nums[i] != nums[i - 1]) {
                    res++;
                    prevAsc = nums[i] > nums[i - 1];
                }
            } else {
                if (prevAsc) {
                    if (nums[i] < nums[i - 1]) {
                        prevAsc = false;
                        res++;
                    }
                } else {
                    if (nums[i] > nums[i - 1]) {
                        prevAsc = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
