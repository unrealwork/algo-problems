package com.leetcode.math;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
  private static final Map<Character, Integer> ROMAN_DIGIT_DICT = romanDict();

  private RomanToInteger() {}

  private static Map<Character, Integer> romanDict() {
    final Map<Character, Integer> dict = new HashMap<>();
    dict.put('I', 1);
    dict.put('V', 5);
    dict.put('X', 10);
    dict.put('L', 50);
    dict.put('C', 100);
    dict.put('D', 500);
    dict.put('M', 1000);
    return Collections.unmodifiableMap(dict);
  }

  public static int romanToInt(String s) {
    int res = 0;
    int accPart = 0;
    if (isOneDigitNumber(s)) {
      return ROMAN_DIGIT_DICT.get(s.charAt(0));
    }
    for (int i = 0; i < s.length() - 1; i++) {
      int currentRomanDigit = romanDigitToDecimal(s, i);
      int nextRomanDigit = romanDigitToDecimal(s, i + 1);
      accPart += currentRomanDigit;

      if (isPreLastIndex(s, i)) {
        res += nextRomanDigit;
      }
      if (currentRomanDigit != nextRomanDigit) {
        res += nextRomanDigit > currentRomanDigit ? -accPart : accPart;
        accPart = 0;
      }
    }
    res += accPart;
    return res;
  }

  private static int romanDigitToDecimal(final String s, final int i) {
    return ROMAN_DIGIT_DICT.get(s.charAt(i));
  }

  private static boolean isOneDigitNumber(String s) {
    return s.length() < 2;
  }

  private static boolean isPreLastIndex(String s, int index) {
    return s.length() - 2 == index;
  }
}
