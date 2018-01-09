package com.hackerrank.contest.euler;

import java.util.Scanner;

public class Euler101 {


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      int n = in.nextInt();
      System.out.println(solve(n));
    }
  }

  private static long solve(int n) {
    int count3 = (n - 1) / 3;
    int count5 = (n - 1) / 5;
    int count15 = (n - 1) / 15;
    long sum3 = getSum(count3, 3);
    long sum5 = getSum(count5, 5);
    long sum15 = getSum(count15, 15);
    return -sum15 + sum3 + sum5;
  }

  private static long getSum(long n, int d) {
    return (n > 0) ? (d * 2 + (n - 1) * d) * n / 2 : 0;
  }

}
