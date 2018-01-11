package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class PickingNumbers {


  static int pickingNumbers(int[] a) {
    // Complete this function
    int count = 0;
    Arrays.sort(a);
    int lastShift = 0;
    int currentCount = 1;
    int max = a[0];
    for (int i = 1; i < a.length; i++) {
      if (a[i] > max) {
        if (a[i] - max > 1) {
          lastShift = i;
          max = a[lastShift];
          if (currentCount > count) {
            count = currentCount;
            i = lastShift;
          }
          currentCount = 1;
        } else {
          currentCount++;
        }
      } else {
        currentCount++;
      }
    }
    if (currentCount > count) {
      count = currentCount;
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] a = new int[n];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
    }
    int result = pickingNumbers(a);
    System.out.println(result);
    in.close();
  }
}
