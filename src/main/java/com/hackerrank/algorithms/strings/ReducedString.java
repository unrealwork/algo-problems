package com.hackerrank.algorithms.strings;

import java.util.Scanner;

public class ReducedString {

  static String superReducedString(String s) {
    // Complete this function
    String cur = s;
    String next = reduce(s);
    while (!cur.equals(next)) {
      cur = next;
      next = reduce(cur);
    }
    return cur.length() > 0? cur: "Empty String";
  }

  static String reduce(String s) {
    StringBuilder sb = new StringBuilder();
    char previous = (char) 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (previous > 0) {
        if (previous == c) {
          previous = (char) 0;
        } else {
          sb.append(previous);
          previous = c;
        }
      } else {
        previous = c;
      }
    }
    if (previous > 0) {
      sb.append(previous);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    String result = superReducedString(s);
    System.out.println(result);
  }
}
