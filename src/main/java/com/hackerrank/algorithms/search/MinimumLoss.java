package com.hackerrank.algorithms.search;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Lauren has a chart of distinct projected prices for a house over the next several years. She must
 * buy the house in one year and sell it in another, and she must do so at a loss. She wants to
 * minimize her financial loss.
 *
 * @see <a href="https://www.hackerrank.com/challenges/minimum-loss/problem">Minimum Loss</a>
 */
public class MinimumLoss {
  private MinimumLoss() {}

  public static long minimumLoss(List<Long> p) {
    // Write your code here
    long res = Long.MAX_VALUE;
    Map<Long, Integer> indexMap = indexMap(p);
    List<Long> sPrices = p.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    for (int i = 0; i < sPrices.size() - 1; i++) {
      long startPrice = sPrices.get(i);
      final int startPriceIndex = indexMap.get(startPrice);
      int j = i + 1;
      long nextPrice = sPrices.get(j);
      while (indexMap.get(nextPrice) < startPriceIndex) {
        j++;
        if (j >= sPrices.size()) {
          break;
        }
        nextPrice = sPrices.get(j);
      }
      if (j < sPrices.size()) {
        long loss = startPrice - nextPrice;
        if (loss < res) {
          res = loss;
        }
      }
    }
    return res;
  }

  private static Map<Long, Integer> indexMap(List<Long> p) {
    int i = 0;
    final Map<Long, Integer> map = new HashMap<>();
    for (Long aLong : p) {
      map.put(aLong, i);
      i++;
    }
    return Collections.unmodifiableMap(map);
  }
}
