package com.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {
  private GroupAnagrams() {}

  public static List<List<String>> groupAnagrams(String[] strs) {
    return new ArrayList<>(Arrays.stream(strs)
            .collect(Collectors.groupingBy(AnagramKey::fromString))
            .values());
  }

  private static class AnagramKey {
    public static final int ALPHABET_SIZE = 26;
    private final int[] letterCounters;

    private AnagramKey(int[] letterCounters) {
      this.letterCounters = letterCounters;
    }

    public static AnagramKey fromString(final String src) {
      int[] letterCounters = new int[ALPHABET_SIZE];
      for (int i = 0; i < src.length(); i++) {
        final int letterIndex = src.charAt(i) - 'a';
        letterCounters[letterIndex]++;
      }
      return new AnagramKey(letterCounters);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      AnagramKey that = (AnagramKey) o;
      return Arrays.equals(letterCounters, that.letterCounters);
    }

    @Override
    public int hashCode() {
      return Arrays.hashCode(letterCounters);
    }
  }
}
