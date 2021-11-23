package com.leetcode.ds.hashmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RansomNote {
  private RansomNote() {}

  private static Map<Character, Long> dict(String s) {
    final Map<Character, Long> dict = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      final char c = s.charAt(i);
      dict.putIfAbsent(c, 0L);
      dict.computeIfPresent(c, (k, v) -> v + 1);
    }
    return Collections.unmodifiableMap(dict);
  }

  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Long> ransomDict = dict(ransomNote);
    Map<Character, Long> magazineDict = dict(magazine);
    for (Map.Entry<Character, Long> entry : ransomDict.entrySet()) {
      Long v = magazineDict.get(entry.getKey());
      if (v == null || entry.getValue() > v) {
        return false;
      }
    }
    return true;
  }
}
