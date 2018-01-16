package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class BeautifulDays {

  static int beautifulDays(int i, int j, int k) {
    // Complete this function
    int count = 0;
    for (int index = i; index <= j; index++) {
      if ((index - reverse(index)) % k == 0) {
        count++;
      }
    }
    return count;
  }

  private static int reverse(int i) {
    return Integer
        .parseInt(new StringBuilder(Integer.toString(i)).reverse().toString());
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int i = in.nextInt();
    int j = in.nextInt();
    int k = in.nextInt();
    int result = beautifulDays(i, j, k);
    System.out.println(result);
    in.close();
  }
}
