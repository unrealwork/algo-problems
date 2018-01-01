package com.hackerrank.algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class FindMedian {
  static int findMedian(int[] arr) {
    // Complete this function
    Arrays.sort(arr);
    final int midIndex = arr.length / 2;
    return arr.length % 2 == 0 ? (arr[midIndex] + arr[midIndex]) / 2
        : arr[midIndex];
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int arr_i = 0; arr_i < n; arr_i++) {
      arr[arr_i] = in.nextInt();
    }
    int result = findMedian(arr);
    System.out.println(result);
    in.close();
  }
}
