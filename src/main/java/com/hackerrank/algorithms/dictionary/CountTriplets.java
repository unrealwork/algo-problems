package com.hackerrank.algorithms.dictionary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given an array and you need to find number of tripets of indices such that the elements
 * at those indices are in geometric progression for a given common ratio.
 *
 * @see <a href="https://www.hackerrank.com/challenges/count-triplets-1/problem">Count Triplets</a>
 */
public class CountTriplets {
  // Complete the countTriplets function below.
  static long countTriplets(List<Long> arr, long r) {
    TripletsCounter tripletsCounter = new TripletsCounter(r);
    for (Long num : arr) {
      tripletsCounter.updateCounters(num);
    }
    return tripletsCounter.getCount();
  }

  private static class TripletsCounter {
    private final long ratio;
    private final Map<Long, Map<Long, Long>> lengthLastCountMap = initMap();
    private long count = 0;

    private TripletsCounter(long r) {
      this.ratio = r;
    }

    private HashMap<Long, Map<Long, Long>> initMap() {
      final HashMap<Long, Map<Long, Long>> longMapHashMap = new HashMap<>();
      for (long i = 0; i < 3L; i++) {
        longMapHashMap.put(i, new HashMap<>());
      }
      return longMapHashMap;
    }

    public void updateCounters(final long n) {
      final boolean dividableByR = n % ratio == 0;
      if (n > ratio && dividableByR || ratio == 1) {
        final long previous = n / ratio;
        final Long previousCount = lengthLastCountMap.get(2L).get(previous);
        if (previousCount != null) {
          count += previousCount;
        }
      }
      if (n > 1 && dividableByR || ratio == 1) {
        final long previous = n / ratio;
        final Long previousCount = lengthLastCountMap.get(1L).get(previous);
        if (previousCount != null) {
          lengthLastCountMap.get(2L).putIfAbsent(n, 0L);
          lengthLastCountMap.get(2L).computeIfPresent(n, (num, count) -> count + previousCount);
        }
      }
      lengthLastCountMap.get(1L).putIfAbsent(n, 0L);
      lengthLastCountMap.get(1L).computeIfPresent(n, (num, count) -> count + 1);
    }

    public long getCount() {
      return count;
    }
  }
}
