package com.hackerrank.algorithms.warmup;

import java.util.Scanner;

public class Staircase {


  private static void staircase(int n) {
    // Complete this function
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(j < (n - i - 1) ? " " : "#");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    staircase(n);
    in.close();
  }

}
