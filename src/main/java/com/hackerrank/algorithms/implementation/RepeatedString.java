package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class RepeatedString {

  static long repeatedString(String s, long n) {
    // Complete this function
    long aCount = s.chars().filter(c -> c == 'a').count();
    long rest = n % s.length();
    return aCount * (n / s.length()) + s.chars().limit(rest)
        .filter(c -> c == 'a').count();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    long n = in.nextLong();
    long result = repeatedString(s, n);
    System.out.println(result);
    in.close();
  }
}
