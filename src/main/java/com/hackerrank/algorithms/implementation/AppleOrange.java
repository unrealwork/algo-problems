package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class AppleOrange {


  static int[] appleAndOrange(int s, int t, int a, int b, int[] apple,
      int[] orange) {

    int applesCount = Arrays.stream(apple)
        .map(v -> v + a)
        .filter(v -> v >= s && v <= t)
        .toArray().length;

    int orangesCount = Arrays.stream(orange)
        .map(v -> b + v)
        .filter(v -> v >= s && v <= t)
        .toArray().length;
    return new int[]{applesCount, orangesCount};
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    int t = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();
    int m = in.nextInt();
    int n = in.nextInt();
    int[] apple = new int[m];
    for (int apple_i = 0; apple_i < m; apple_i++) {
      apple[apple_i] = in.nextInt();
    }
    int[] orange = new int[n];
    for (int orange_i = 0; orange_i < n; orange_i++) {
      orange[orange_i] = in.nextInt();
    }
    int[] result = appleAndOrange(s, t, a, b, apple, orange);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
    }
    System.out.println("");

    in.close();
  }
}


