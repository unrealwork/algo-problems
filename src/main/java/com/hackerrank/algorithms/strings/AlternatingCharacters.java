package com.hackerrank.algorithms.strings;

import java.util.Scanner;

public class AlternatingCharacters {


  static int alternatingCharacters(String s) {
    // Complete this function
    char c = s.charAt(0);
    int res = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      char next = s.charAt(i + 1);
      if (c == next) {
        res++;
      }
      c = next;
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      String s = in.next();
      int result = alternatingCharacters(s);
      System.out.println(result);
    }
  }
}
