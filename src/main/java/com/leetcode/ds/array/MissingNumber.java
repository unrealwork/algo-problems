package com.leetcode.ds.array;

/**
 * Given an array nums containing <i>n</i> distinct numbers in the range <i>[0, n]</i>, return the only number in the range that is missing from the array.
 * <br>
 * <a href="https://leetcode.com/problems/missing-number/">Missing Number</a>
 *
 * @author unrealwork
 */
public final class MissingNumber {
    private MissingNumber() {

    }

    public static int missingNumber(int[] nums) {
        int expectedSum = (nums.length + 1) * nums.length / 2;
        for (int num : nums) {
            expectedSum -= num;
        }
        return expectedSum;
    }
}
