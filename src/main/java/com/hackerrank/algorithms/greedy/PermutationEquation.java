package com.hackerrank.algorithms.greedy;

import java.util.Scanner;

public class PermutationEquation {

  static int[] permutationEquation(int[] p) {
    // Complete this function
    int[] reverse = new int[p.length];
    for (int i = 0; i < p.length; i++) {
      reverse[p[i] - 1] = i;
    }
    int[] res = new int[p.length];
    for (int i = 0; i < p.length; i++) {
      res[i] = reverse[reverse[i]] + 1;
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] p = new int[n];
    for (int p_i = 0; p_i < n; p_i++) {
      p[p_i] = in.nextInt();
    }
    int[] result = permutationEquation(p);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
    }
    System.out.println("");

    in.close();
  }
}
