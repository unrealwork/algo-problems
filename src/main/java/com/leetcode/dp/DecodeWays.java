package com.leetcode.dp;

public class DecodeWays {
  private DecodeWays() {}

  public static int numDecodings(String s) {
    if (s.length() == 0 || !valid(digit(s, 0))) {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }

    int pp = 1;
    int p = 1;
    for (int i = 1; i < s.length(); i++) {
      final int d = digit(s, i);
      final int dd = doubleDigit(s, i);
      if (valid(d) || valid(dd)) {
        int cur = (valid(d) ? p : 0) + (valid(dd) ? pp : 0);
        pp = p;
        p = cur;
      } else {
        return 0;
      }
    }
    return p;
  }

  private static int digit(final char c) {
    return c - '0';
  }

  private static int digit(final String s, int i) {
    return digit(s.charAt(i));
  }

  private static int doubleDigit(final String s, int i) {
    final int prevD = digit(s, i - 1);
    if (!valid(prevD)) {
      return 0;
    }
    return prevD * 10 + digit(s, i);
  }

  private static boolean valid(final int c) {
    return c > 0 && c < 27;
  }
}
