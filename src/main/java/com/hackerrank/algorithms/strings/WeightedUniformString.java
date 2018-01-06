package com.hackerrank.algorithms.strings;

import com.hackerrank.Solution;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WeightedUniformString implements Solution {

  public static void main(String[] args) {
    new WeightedUniformString().solve(System.in, System.out);
  }

  @Override
  public OutputStream solve(InputStream is, PrintStream os) {
    long limit = 10000001L;
    Scanner in = new Scanner(is);
    String s = in.next();
    int n = in.nextInt();
    final Map<Integer, Long> dict = createDict(s);
    for (int a0 = 0; a0 < n; a0++) {
      long x = in.nextLong();
      // your code goes here
      if (a0 == 5102) {
        int a = 0;
      }
      os.println(check(dict, x) ? "Yes" : "No");
    }
    return os;
  }

  public static Map<Integer, Long> createDict(String s) {
    final Map<Integer, Long> dict = new HashMap<>();
    long substringLength = 1;
    int previous = s.charAt(0) - 'a' + 1;
    for (int i = 1; i < s.length(); i++) {
      int c = s.charAt(i) - 'a' + 1;
      if (previous == c) {
        substringLength++;
      } else {
        addToDict(dict, substringLength, previous);
        substringLength = 1;
      }
      previous = c;
    }
    addToDict(dict, substringLength, previous);
    return dict;
  }

  public static void addToDict(Map<Integer, Long> dict, long substringLength,
      int c) {

    if (dict.containsKey(c)) {
      long count = dict.get(c);
      if (substringLength > count) {
        dict.put(c, substringLength);
      }
    } else {
      dict.put(c, substringLength);
    }
  }

  private boolean check(Map<Integer, Long> dict, long x) {
    for (int symbol : dict.keySet()) {
      if (x % symbol == 0) {
        Long count = dict.get(symbol);
        long expectedCount = x / symbol;
        if (expectedCount >= 1 && expectedCount <= count) {
          return true;
        }
      }
    }
    return false;
  }
}
