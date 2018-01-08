package com.hackerrank.algorithms.greedy;

import java.util.Scanner;

public class SherlockBeast {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int i = 0; i < t; i++) {
      System.out.println(solve(in.nextInt()));
    }
  }

  private static String solve(int n) {
    int right = 0;
    int left = n;
    while (left > -1 && left % 3 != 0) {
      right += 5;
      left -= 5;
    }
    if (left < 0) {
      return "-1";
    } else {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < left; i++) {
        sb.append(5);
      }
      for (int i = 0; i < right; i++) {
        sb.append(3);
      }
      return sb.toString();
    }
  }
}
