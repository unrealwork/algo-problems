package com.hackerrank.algorithms.strings;

import java.util.Scanner;

public class MarsExploration {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println(solve(in.nextLine()));
    in.close();
  }

  private static int solve(String s) {
    StringBuilder sb = new StringBuilder();
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int mod = i % 3;
      if (mod == 1) {
        if (c != 'O') {
          res++;
        }
      } else {
        if (c != 'S') {
          res++;
        }
      }
    }
    return res;
  }
}
