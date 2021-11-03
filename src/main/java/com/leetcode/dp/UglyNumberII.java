package com.leetcode.dp;

import java.util.TreeSet;

public class UglyNumberII {
  private static final int LIMIT_5 = Integer.MAX_VALUE / 5;
  private static final int LIMIT_3 = Integer.MAX_VALUE / 3;
  private static final int LIMIT_2 = Integer.MAX_VALUE / 2;

  private UglyNumberII() {}

  public static int nthUglyNumber(int n) {
    if (n == 1) {
      return 1;
    } else {
      TreeSet<Integer> res = new TreeSet<>();
      int p = 1;
      for (int i = 1; i < n; i++) {
        if (p <= LIMIT_2) {
          res.add(p * 2);
        }
        if (p <= LIMIT_3) {
          res.add(p * 3);
        }
        if (p <= LIMIT_5) {
          res.add(p * 5);
        }
        res.remove(p);
        p = res.first();
      }
      return p;
    }
  }
}
