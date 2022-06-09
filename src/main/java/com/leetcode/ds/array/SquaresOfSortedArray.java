package com.leetcode.ds.array;

class SquaresOfSortedArray {
    private SquaresOfSortedArray() {
    }

    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int j = res.length - 1;
        int left = 0;
        int right = j;
        while (j > -1) {
            if (nums[left] < 0 && -nums[left] > nums[right]) {
                res[j] = nums[left] * nums[left];
                left++;
            } else {
                res[j] = nums[right] * nums[right];
                right--;
            }
            j--;
        }
        return res;
    }
}
