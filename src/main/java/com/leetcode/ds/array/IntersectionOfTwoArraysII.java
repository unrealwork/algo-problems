package com.leetcode.ds.array;

import java.util.Arrays;

public class IntersectionOfTwoArraysII {
  private IntersectionOfTwoArraysII() {}

  public static int[] intersect(int[] nums1, int[] nums2) {
    final int minLength = Math.min(nums2.length, nums1.length);
    return minLength == nums1.length
        ? intersect(minLength, nums1, nums2)
        : intersect(minLength, nums2, nums1);
  }

  private static int[] intersect(int minLength, int[] lessArray, int[] bigArray) {
    int[] res = new int[minLength];
    Arrays.sort(lessArray);
    Arrays.sort(bigArray);
    int i = 0;
    int j = 0;
    for (int e : lessArray) {
      while (i < bigArray.length && bigArray[i] < e) {
        i++;
      }
      if (i < bigArray.length && bigArray[i] == e) {
        res[j] = e;
        j++;
        i++;
      }
    }
    return Arrays.copyOf(res, j);
  }
}
