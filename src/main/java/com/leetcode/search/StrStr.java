package com.leetcode.search;

public class StrStr {
  private StrStr() {}

  private static int[] lps(String pattern) {
    int[] lps = new int[pattern.length()];
    for (int i = 1; i < pattern.length(); i++) {
      if (pattern.charAt(lps[i - 1]) == pattern.charAt(i)) {
        lps[i] = lps[i - 1] + 1;
      } else {
        lps[i] = 0;
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
