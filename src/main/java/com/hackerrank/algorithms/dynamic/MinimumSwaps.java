package com.hackerrank.algorithms.dynamic;

public class MinimumSwaps {
  private MinimumSwaps() {}

  static int minimumSwaps(int[] arr) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      while (arr[i] != (i + 1)) {
        swap(i, arr[i] - 1, arr);
        count++;
      }
    }
    return count;
  }

  private static void swap(int i, int j, int[] arr) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
