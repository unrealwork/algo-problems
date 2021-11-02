package com.leetcode.dp;

public class ArithmeticSlices {
  public static int numberOfArithmeticSlices(int[] nums) {
    if (nums.length < 3) {
      return 0;
    }
    int res = 0;
    int count = 2;
    int curDiff = nums[1] - nums[0];
    for (int i = 2; i < nums.length; i++) {
      final int diff = nums[i] - nums[i - 1];
      if (diff == curDiff) {
        count++;
        if (count >= 3) {
          res += (count - 2);
        }
      } else {
        curDiff = diff;
        count = 2;
      }
    }
    return res;
  }
}
