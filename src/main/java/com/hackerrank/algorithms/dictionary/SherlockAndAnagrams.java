package com.hackerrank.algorithms.dictionary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the
 * other string. Given a string, find the number of pairs of substrings of the string that are
 * anagrams of each other.
 *
 * @see <a href="https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem">Sherlock and
 *     Anagrams</a>
 */
public class SherlockAndAnagrams {

  private SherlockAndAnagrams() {}

  static int sherlockAndAnagrams(String s) {
    Map<Integer, Map<Character, Integer>> map = new HashMap<>();
    int res = 0;
    for (int angramStart = s.length(); angramStart > 0; angramStart--) {
      for (int i = 0; i < angramStart; i++) {
        final Map<Character, Integer> subStringMap = map.computeIfAbsent(i, c -> new HashMap<>());
        final char newSymbol = s.charAt(i + (s.length() - angramStart));
        subStringMap.putIfAbsent(newSymbol, 0);
        subStringMap.computeIfPresent(newSymbol, (c, count) -> count + 1);
      }
      for (int i = 0; i < angramStart - 1; i++) {
        for (int j = i + 1; j < angramStart; j++) {
          if (map.get(i).equals(map.get(j))) {
            res++;
          }
        }
      }
    }
    return res;
  }

}
