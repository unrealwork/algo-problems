package com.hackerrank.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class PriyankaToys {


  static int toys(int[] w) {
    // Complete this function
    Arrays.sort(w);
    int total = 1;
    int freeLimit = w[0] + 4;
    for (int i = 1; i < w.length; i++) {
      if (w[i] > freeLimit) {
        total++;
        freeLimit = w[i] + 4;
      }
    }
    return total;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] w = new int[n];
    for (int w_i = 0; w_i < n; w_i++) {
      w[w_i] = in.nextInt();
    }
    int result = toys(w);
    System.out.println(result);
    in.close();
  }

}
