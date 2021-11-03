package com.leetcode.search;

public class StrStr {
  private StrStr() {}

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

  public static int strStr(String haystack, String needle) {
    int[] lps = lps(needle);
    if (haystack.isEmpty() && needle.isEmpty()) {
      return 0;
    }
    int j = 0;
    int limit = haystack.length() - needle.length() + 1;
    for (int i = 0; i < limit; i++) {
      while (j < needle.length()) {
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          j = j > 0 ? lps[j - 1] : 0;
          break;
        }
        j++;
      }
      if (j == needle.length()) {
        return i;
      }
    }
    return -1;
  }
}
