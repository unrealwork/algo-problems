package com.hackerrank.algorithms.greedy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers and a target value, determine the number of pairs of array elements
 * that have a difference equal to the target value.
 *
 * @see <a href="https://www.hackerrank.com/challenges/pairs/problem">Pairs</a>
 */
public class Pairs {
  private Pairs() {}

  public static int pairs(int k, List<Integer> arr) {
    // Write your code here
    final Map<Integer, Integer> dict = dict(arr);
    int res = 0;
    for (Integer num : arr) {
      final int diff = num - k;
      if (dict.containsKey(diff)) {
        res += dict.get(diff);
      }
    }
    return res;
  }

  private static Map<Integer, Integer> dict(List<Integer> nums) {
    final Map<Integer, Integer> res = new HashMap<>();
    for (Integer num : nums) {
      res.putIfAbsent(num, 0);
      res.computeIfPresent(num, (n, count) -> count + 1);
    }
    return res;
  }
}
