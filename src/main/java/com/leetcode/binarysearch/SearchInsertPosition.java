package com.leetcode.binarysearch;

public class SearchInsertPosition {
    private SearchInsertPosition() {
        
    }

    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int middleIndex = i + (j - i) / 2;
            if (nums[middleIndex] == target) {
                return middleIndex;
            } else {
                if (nums[middleIndex] > target) {
                    j = middleIndex - 1;
                } else {
                    i = middleIndex + 1;
                }
            }
        }
        return i;
    }
}
