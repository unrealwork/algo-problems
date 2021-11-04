package com.leetcode.string;

public class CountAndSay {
  private CountAndSay() {}

  public static String countAndSay(int n) {
    if (n < 2) {
      return "1";
    } else {
      String p = "1";
      for (int i = 1; i < n; i++) {
        p = say(p);
      }
      return p;
    }
  }

  private static String say(String s) {
    final StringBuilder sb = new StringBuilder();
    char c = s.charAt(0);
    int count = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == c) {
        count++;
      } else {
        sb.append(count);
        sb.append(c);
        c = s.charAt(i);
        count = 1;
      }
    }
    sb.append(count);
    sb.append(c);
    return sb.toString();
  }
}
