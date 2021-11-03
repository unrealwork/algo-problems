package com.leetcode.search;

public class RepeatedSubstringPattern {
  private RepeatedSubstringPattern() {}

  public static boolean repeatedSubstringPattern(String s) {
    int[] lps = lps(s);
    final int n = s.length();

    return (lps[n - 1] > 0 && lps[n - 1] % (n - lps[n - 1]) == 0);
  }

  private static int[] lps(String pat) {
    int len = 0;
    int i = 1;
    int[] lps = new int[pat.length()];
    if (lps.length == 0) {
      return lps;
    }
    int m = lps.length;
    lps[0] = 0;

    while (i < m) {
      if (pat.charAt(i) == pat.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
      } else {
        if (len != 0) {
          len = lps[len - 1];
        } else {
          lps[i] = len;
          i++;
        }
      }
    }
    return lps;
  }
}
