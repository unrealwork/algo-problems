package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class NonDivisibleSubset {

  static int nonDivisibleSubset(int k, int[] arr) {
    // Complete this function
    int[] remainders = new int[k];
    int res = 0;
    for (int elem : arr) {
      remainders[elem % k]++;
    }
    int max;
    int maxRemainder;
    do {
      max = remainders[0];
      maxRemainder = 0;
      for (int i = 1; i < remainders.length; i++) {
        if (remainders[i] > max) {
          max = remainders[i];
          maxRemainder = i;
        }
      }
      if (max > 0) {
        if (maxRemainder == 0 || maxRemainder * 2 == k) {
          res++;
        } else {
          remainders[k - maxRemainder] = 0;
          res += max;
        }
      }
      remainders[maxRemainder] = 0;
    } while (max > 0);
    return res;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int[] arr = new int[n];
    for (int arr_i = 0; arr_i < n; arr_i++) {
      arr[arr_i] = in.nextInt();
    }
    int result = nonDivisibleSubset(k, arr);
    System.out.println(result);
    in.close();
  }
}
