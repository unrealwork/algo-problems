package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class CountingValleys {


  static int countingValleys(int n, String s) {
    // Complete this function
    int level = 0;
    int valleyCount = 0;
    for (char c : s.toCharArray()) {
      if (level == 0 && c == 'D') {
        valleyCount++;
      }
      if (c == 'D') {
        level--;
      } else {
        level++;
      }
    }
    return valleyCount;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String s = in.next();
    int result = countingValleys(n, s);
    System.out.println(result);
    in.close();
  }

}
