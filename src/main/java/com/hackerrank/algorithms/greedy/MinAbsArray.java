package com.hackerrank.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MinAbsArray {

  static int minimumAbsoluteDifference(int n, int[] arr) {
    // Complete this function
    Arrays.sort(arr);
    int res = arr[1] - arr[0];
    for (int i = 2; i < arr.length; i++) {
      int abs = Math.abs(arr[i] - arr[i - 1]);
      if (abs < res) {
        res = abs;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int arr_i = 0; arr_i < n; arr_i++) {
      arr[arr_i] = in.nextInt();
    }
    int result = minimumAbsoluteDifference(n, arr);
    System.out.println(result);
    in.close();
  }
}
