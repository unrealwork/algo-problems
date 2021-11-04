package com.leetcode.string;

public class MyAtoi {
  private MyAtoi() {}

  public static int myAtoi(String s) {
    int i = 0;
    while (i < s.length() && s.charAt(i) == ' ') i++;

    if (i == s.length()) {
      return 0;
    }
    final char c = s.charAt(i);
    if (!Character.isDigit(c) && c != '-' && c != '+') {
      return 0;
    }
    boolean isNegative = c == '-';
    i++;
    return readNumber(s, i, c, isNegative);
  }

  private static int readNumber(String s, int i, char c, boolean isNegative) {
    int res = 0;
    if (Character.isDigit(c)) {
      res += digit(c);
    }

    for (int j = i; j < s.length() && Character.isDigit(s.charAt(j)); j++) {
      int d = digit(s.charAt(j));
      if (isOverflow(res, d, isNegative)) {
        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
      res *= 10;
      res += d;
    }
    return isNegative ? -res : res;
  }

  private static int digit(char c) {
    return c - '0';
  }

  private static boolean isOverflow(int res, int d, boolean isNegative) {
    if (res > Integer.MAX_VALUE / 10) {
      return true;
    }
    int res10 = res * 10;
    return isNegative ? (-res10 < Integer.MIN_VALUE + d) : (res10 > Integer.MAX_VALUE - d);
  }
}
