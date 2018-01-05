package com.hackerrank.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyFlorist {

  static int getMinimumCost(int n, int k, int[] c) {
    // Complete this function
    Arrays.sort(c);
    int sum = 0;
    int factor = 1;
    for (int i = n - 1; i >= 0; i -= k) {

      for (int j = i; j > -1 && j > (i - k); j--) {
        sum += (c[j] * factor);
      }
      factor++;
    }
    return sum;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int[] c = new int[n];
    for (int c_i = 0; c_i < n; c_i++) {
      c[c_i] = in.nextInt();
    }
    int minimumCost = getMinimumCost(n, k, c);
    System.out.println(minimumCost);
  }
}
