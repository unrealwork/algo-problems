package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class JumpingClouds {

  static int jumpingOnClouds(int[] c, int k) {
    // Complete this function
    int pos = 0;
    int energy = 100;
    do {
      pos = (pos + k) % c.length;
      energy--;
      if (c[pos] == 1) {
        energy -= 2;
      }
    } while (pos != 0);
    return energy;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int[] c = new int[n];
    for (int c_i = 0; c_i < n; c_i++) {
      c[c_i] = in.nextInt();
    }
    int result = jumpingOnClouds(c, k);
    System.out.println(result);
    in.close();
  }
}
