package com.hackerrank.algorithms.strings;

import java.util.Scanner;

public class FunnyString {

  public static class Result {

    public static final String FUNNY = "Funny";
    public static final String NOT_FUNNY = "Not Funny";
  }

  static String funnyString(String s) {
    // Complete this function
    int length = s.length();
    int[] arr = new int[length - 1];
    char c = s.charAt(0);
    for (int i = 1; i < length; i++) {
      char currentChar = s.charAt(i);
      arr[i - 1] = Math.abs(currentChar - c);
      c = currentChar;
    }
    return isPalindrome(arr) ? Result.FUNNY : Result.NOT_FUNNY;
  }

  public static boolean isPalindrome(int[] a) {
    final int mid = a.length / 2;
    for (int i = 0; i < mid; i++) {
      if (a[i] != a[a.length - i - 1]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      String s = in.next();
      String result = funnyString(s);
      System.out.println(result);
    }
  }
}
