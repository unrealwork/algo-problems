package com.hackerrank.algorithms.strings;

import java.util.Scanner;

public class LoveLetter {

  static int theLoveLetterMystery(String s) {
    int length = s.length();
    int res = 0;
    for (int i = 0; i < length / 2; i++) {
      int left = s.charAt(i);
      int right = s.charAt(length - i - 1);
      res += Math.abs(right - left);
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      String s = in.next();
      int result = theLoveLetterMystery(s);
      System.out.println(result);
    }
  }
}
