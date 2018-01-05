package com.hackerrank.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MarkToys {

  static int maximumToys(int[] prices, int k) {
    // Complete this function
    Arrays.sort(prices);
    int res = 0;
    int sum = prices[0];
    for (int i = 1; i < prices.length && sum <= k; i++) {
      res++;
      sum += prices[i];
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int[] prices = new int[n];
    for (int prices_i = 0; prices_i < n; prices_i++) {
      prices[prices_i] = in.nextInt();
    }
    int result = maximumToys(prices, k);
    System.out.println(result);
    in.close();
  }
}
