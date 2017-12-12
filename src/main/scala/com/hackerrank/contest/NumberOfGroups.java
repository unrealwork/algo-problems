package com.hackerrank.contest;

import java.util.Scanner;

public class NumberOfGroups {

  static long sumOfSequence(long a1, long d, long n) {
    return (2 * a1 + d * (n - 1))*n / 2;
  }

  static long sumOfGroup(int k) {
    final long start = 1 + 2 * sumOfSequence(1, 1, k - 1);
    return sumOfSequence(start, 2, k);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int k = in.nextInt();
    long answer = sumOfGroup(k);
    System.out.println(answer);
    in.close();
  }
}