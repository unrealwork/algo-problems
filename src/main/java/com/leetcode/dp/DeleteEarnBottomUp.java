package com.leetcode.dp;

import java.util.Map;
import java.util.TreeMap;

public class DeleteEarnBottomUp {
  private DeleteEarnBottomUp() {}

  public static int deleteAndEarn(int[] nums) {
    Map<Integer, Integer> countMap = new TreeMap<>();
    for (int num : nums) {
      countMap.putIfAbsent(num, 0);
      countMap.computeIfPresent(num, (k, v) -> v + 1);  
    }
    int[] dp = new int[countMap.size()];
    final Integer[] keys = countMap.keySet().toArray(new Integer[] {countMap.size()});
    for (int i = 0; i < keys.length; i++) {
      Integer k = keys[i];
      if (i == 0) {
        dp[i] = countMap.get(k) * k;
      } else {
        final int points = k * countMap.get(k);
        if (keys[i - 1] != k - 1) {
          dp[i] = dp[i - 1] + points;
        } else {
          dp[i] = Math.max(i > 1 ? dp[i - 2] + points : points, dp[i - 1]);
        }
      }
    }
    return dp[keys.length - 1];
  }
}
