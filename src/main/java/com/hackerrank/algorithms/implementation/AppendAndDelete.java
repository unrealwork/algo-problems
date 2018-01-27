package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class AppendAndDelete {

  static String appendAndDelete(String s, String t, int k) {
    // Complete this function
    int i = 0;
    while (i < s.length() && i < t.length() && t.charAt(i) == s.charAt(i)) {
      i++;
    }
    int minOperations = s.length() - i + t.length() - i;
    if (minOperations > k) {
      return "No";
    } else {
      int restOperations = k - minOperations;
      if (k > 2*t.length()) {
        return "Yes";
      }
      if (restOperations % 2 == 0) {
        return "Yes";
      } else {
        return "No";
      }
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    String t = in.next();
    int k = in.nextInt();
    String result = appendAndDelete(s, t, k);
    System.out.println(result);
    in.close();
  }
}
