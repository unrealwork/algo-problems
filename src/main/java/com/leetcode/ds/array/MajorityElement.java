package com.leetcode.ds.array;

final class MajorityElement {
    private MajorityElement() {

    }

    public static int majorityElement(int[] nums) {
        int res = nums[0];
        int counter = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) {
                counter++;
            } else {
                counter--;
            }
            if (counter == 0) {
                res = nums[i];
            }
        }
        return res;
    }
}
