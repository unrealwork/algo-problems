package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class FindDigits {


  static int findDigits(int n) {
    // Complete this function
    int rest = n;
    int count = 0;
    while (rest > 0) {
      int digit = rest % 10;
      if (digit > 0 && n % digit == 0) {
        count++;
      }
      rest /= 10;
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      int n = in.nextInt();
      int result = findDigits(n);
      System.out.println(result);
    }
    in.close();
  }

}
