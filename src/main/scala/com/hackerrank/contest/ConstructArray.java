package com.hackerrank.contest;

import java.util.Scanner;

public class ConstructArray {

  private static int ways;
  private static final int LIMIT = 100000000;

  static synchronized long countArray(int n, int k, int x) {
    if (n == 3) {
      if (x == 1) {
        return k - 1;
      } else {
        return k - 2;
      }
    }
    long answer = k - 1;
    for (int i = 0; i < n - 4; i++) {
      answer *= (k - 1);
      if (answer > LIMIT) {
        answer %= LIMIT;
      }
    }
    long l = answer / (k - 1);
    return ((k - 1) + (answer - 1) * (k - 2)) % LIMIT;
  }

  public synchronized static void countRec(int n, int k, int x, int i,
      int prev) {
    if (i == n - 1) {
      ways++;
      if (ways > LIMIT) {
        ways = ways % LIMIT;
      }
    } else if (i == (n - 2)) {
      for (int j = 1; j <= k; j++) {
        if (j != prev && j != x) {
          countRec(n, k, x, i + 1, j);
        }
      }
    } else {
      for (int j = 1; j <= k; j++) {
        if (j != prev) {
          countRec(n, k, x, i + 1, j);
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int x = in.nextInt();
    long answer = countArray(n, k, x);
    System.out.println(answer);
    in.close();
  }
}
