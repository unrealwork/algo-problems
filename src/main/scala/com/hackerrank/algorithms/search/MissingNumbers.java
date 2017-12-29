package com.hackerrank.algorithms.search;

import java.util.Scanner;

public class MissingNumbers {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    final int limit = 10001;
    int[] holder = new int[limit];
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      holder[in.nextInt()]--;
    }
    int m = in.nextInt();
    for (int i = 0; i < m; i++) {
      holder[in.nextInt()]++;
    }
    for (int i = 0; i < limit; i++) {
      if (holder[i] > 0) {
        System.out.printf("%d ", i);
      }
    }
    in.close();
  }
}
