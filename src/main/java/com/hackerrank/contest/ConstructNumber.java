package com.hackerrank.contest;

import java.util.Arrays;
import java.util.Scanner;

public class ConstructNumber {


  static String canConstruct(int[] a) {
    int sum = Arrays.stream(a)
        .map(n -> Integer.toString(n).chars().map(c -> c - (int) '0').sum())
        .sum();
    return sum % 3 == 0 ? "Yes" : "No";
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      int n = in.nextInt();
      int[] a = new int[n];
      for (int a_i = 0; a_i < n; a_i++) {
        a[a_i] = in.nextInt();
      }
      String result = canConstruct(a);
      System.out.println(result);
    }
    in.close();
  }
}
