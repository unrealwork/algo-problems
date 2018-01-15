package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class UtopianTree {

  static int utopianTree(int n) {
    int res = 1;
    int i = 0;
    while (i < n) {
      if (i % 2 != 0) {
        res += 1;
      } else {
        res *= 2;
      }
      i++;
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      int n = in.nextInt();
      int result = utopianTree(n);
      System.out.println(result);
    }
    in.close();
  }
}
