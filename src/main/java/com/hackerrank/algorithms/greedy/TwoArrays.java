package com.hackerrank.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class TwoArrays {

  static String twoArrays(int k, int[] A, int[] B) {
    // Complete this function
    Arrays.sort(A);
    Arrays.sort(B);
    return isPossible(k, A, B, A.length) ? "YES" : "NO";
  }

  private static boolean isPossible(int k, int[] A, int[] B, int n) {
    for (int i = 0; i < n; i++) {
      if (A[i] + B[n - i - 1] < k) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      int n = in.nextInt();
      int k = in.nextInt();
      int[] A = new int[n];
      for (int A_i = 0; A_i < n; A_i++) {
        A[A_i] = in.nextInt();
      }
      int[] B = new int[n];
      for (int B_i = 0; B_i < n; B_i++) {
        B[B_i] = in.nextInt();
      }
      String result = twoArrays(k, A, B);
      System.out.println(result);
    }
    in.close();
  }
}
