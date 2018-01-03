package com.hackerrank.algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

public class HackerlandRadioTransmitters {

  static int hackerlandRadioTransmitters(int[] x, int k) {
    // Complete this function
    Arrays.sort(x);
    int i = 0;
    int transmittersCount = 0;
    while (i < x.length) {
      int j = i;
      while (j < x.length && x[j] - k <= x[i]) {
        j++;
      }
      if (j < x.length) {
        i = j - 1;
        while (j < x.length && x[i] + k >= x[j]) {
          j++;
        }
      }
      i = j;
      transmittersCount++;
    }
    return transmittersCount;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int[] x = new int[n];
    for (int x_i = 0; x_i < n; x_i++) {
      x[x_i] = in.nextInt();
    }
    int result = hackerlandRadioTransmitters(x, k);
    System.out.println(result);
    in.close();
  }
}
