package com.hackerrank.algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

public class SherlockArray {

  public static class Result {

    public static final String YES = "YES";
    public static final String NO = "NO";
  }

  static String solve(int[] a) {
    long right = Arrays.stream(a).skip(1).sum();
    long left = 0;
    if (right == left) {
      return Result.YES;
    }
    for (int i = 1; i < a.length; i++) {
      left += a[i - 1];
      right -= a[i];
      if (left == right) {
        return Result.YES;
      }
    }
    return Result.NO;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int a0 = 0; a0 < T; a0++) {
      int n = in.nextInt();
      int[] a = new int[n];
      for (int a_i = 0; a_i < n; a_i++) {
        a[a_i] = in.nextInt();
      }
      String result = solve(a);
      System.out.println(result);
    }
  }

}
