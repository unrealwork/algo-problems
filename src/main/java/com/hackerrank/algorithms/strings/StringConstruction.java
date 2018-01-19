package com.hackerrank.algorithms.strings;

import java.util.Scanner;

public class StringConstruction {

  static long stringConstruction(String s) {
    // Complete this function
    return s.chars().distinct().count();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      String s = in.next();
      long result = stringConstruction(s);
      System.out.println(result);
    }
    in.close();
  }
}
