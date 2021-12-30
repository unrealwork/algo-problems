package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeats {
  private LongestSubstringWithoutRepeats() {}

  public static int lengthOfLongestSubstring(String s) {
    NonRepeatLetterCounter counter = new NonRepeatLetterCounter();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      counter.update(c, i);
    }
    return counter.maxLength;
  }

  private static class NonRepeatLetterCounter {
    private final Map<Character, Integer> lastIndexMap = new HashMap<>();
    int seqStartIndex = 0;
    private int length = 0;
    private int maxLength = 0;

    public void update(char c, int index) {
      int lastRepeatingIndex = lastIndexMap.getOrDefault(c, -1);

      if (lastRepeatingIndex > -1 && lastRepeatingIndex >= seqStartIndex) {
        length = index - lastRepeatingIndex - 1;
        seqStartIndex = lastRepeatingIndex + 1;
      }
      lastIndexMap.put(c, index);
      length++;
      if (maxLength < length) {
        maxLength = length;
      }
    }
  }
}
