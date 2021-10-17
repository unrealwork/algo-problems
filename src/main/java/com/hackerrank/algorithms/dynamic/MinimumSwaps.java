package com.hackerrank.algorithms.dynamic;

/**
 * You are given an unordered array consisting of consecutive integers [1, 2, 3, ..., n] without any
 * duplicates. You are allowed to swap any two elements. Find the minimum number of swaps required
 * to sort the array in ascending order.
 *
 * @see <a href="https://www.hackerrank.com/challenges/minimum-swaps-2/problem">Minimum Swaps 2</a>
 */
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
