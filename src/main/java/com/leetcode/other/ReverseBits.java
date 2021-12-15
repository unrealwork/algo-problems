package com.leetcode.other;

public class ReverseBits {
  private static final byte TOTAL_BITS = 32;

  private ReverseBits() {}

  public static int reverseBits(int n) {
    int res = 0;
    int notProcessedPart = n;
    for (int bit = TOTAL_BITS - 1; bit > -1; bit--) {
      int mod2 = notProcessedPart & 1;
      res += mod2 << bit;
      notProcessedPart = notProcessedPart >> 1;
    }
    return res;
  }
}
