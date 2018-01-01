package com.hackerrank.algorithms.recursion;

import java.util.Scanner;

public class DigitSum {

  static int digitSum(String n, int k) {
    return digitSum(Long.toString(getNext(n) * k));
  }

  static int digitSum(String number) {
    if (number.length() == 1) {
      return Integer.parseInt(number);
    } else {
      String next = Long.toString(getNext(number));
      return digitSum(next);
    }
  }

  private static long getNext(String number) {
    return number.chars().map(code -> code - (int) '0').sum();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String n = in.next();
    int k = in.nextInt();
    int result = digitSum(n, k);
    System.out.println(result);
    in.close();
  }
}
