package com.leetcode;

public class HappyNumber {

  private static int[] squaresMemo = new int[10];

  static {
    for (int i = 0; i < squaresMemo.length; i++) {
      squaresMemo[i] = i * i;
    }
  }

  private HappyNumber() {}

  public static boolean isHappy(int n) {
    int t = n;
    int h = next(t);
    while (h != 1 && t != h) {
      t = next(t);
      h = next(next(h));
    }
    return h == 1;
  }

  private static int next(int n) {
    int res = 0;
    int rest = n;
    while (rest > 0) {
      int digit = rest % 10;
      res += squaresMemo[digit];
      rest /= 10;
    }
    return res;
  }
}
