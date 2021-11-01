package com.leetcode.twopointers;

public class RemoveDuplicates {
  private RemoveDuplicates() {}

  public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int max = nums[nums.length - 1];
    int i = 0;
    int j = 1;
    while (nums[i] != max) {
      if (nums[i] == nums[i + 1]) {
        j++;
      } else {
        i++;
        j++;
      }
      if (i < nums.length - 1 && j < nums.length) {
        swap(i + 1, j, nums);
      }
    }
    return i + 1;
  }

  private static void swap(int i, int j, int[] nums) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
