package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class BetweenTwoSets {

  static final int LIMIT = 101;

  private static int gcd(int a, int b) {
    while (b > 0) {
      int temp = b;
      b = a % b; // % is remainder
      a = temp;
    }
    return a;
  }

  public static int gcd(int[] a) {
    return Arrays.stream(a).reduce(a[0], BetweenTwoSets::gcd);
  }

  public static long lcm(long a, long b) {
    final int gcd = gcd((int) a, (int) b);
    long res = a / gcd * b;
    if (res > LIMIT) {
      return LIMIT;
    }
    return res;
  }

  public static long lcm(int[] a) {
    return Arrays.stream(a).mapToLong(Long::valueOf)
        .reduce(a[0], BetweenTwoSets::lcm);
  }

  public static boolean isPowerOfTwo(long b) {
    return (b & (b - 1)) == 0;
  }

  public static int solve(int[] a, int[] b) {
    // Complete this function
    final long lower = lcm(a);
    final long upper = gcd(b);
    int res = 0;
    for (long i = lower; i <= upper; i += lower) {
      if (upper % i == 0) {
        res++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
    }
    int[] b = new int[m];
    for (int b_i = 0; b_i < m; b_i++) {
      b[b_i] = in.nextInt();
    }
    int total = solve(a, b);
    System.out.println(total);
    in.close();
  }

}
