package com.leetcode.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
  private ThreeSum() {}

  public static List<List<Integer>> threeSum(int[] nums) {
    final Solver solver = new Solver(nums);
    return solver.solve();
  }

  private static class Solver {
    private final Map<Integer, Integer> indexDict;
    private final int[] sortedNums;

    private Solver(int[] nums) {
      this.sortedNums = sortedArray(nums);
      this.indexDict = indexDict(sortedNums);
    }

    private static Map<Integer, Integer> indexDict(int[] nums) {
      final Map<Integer, Integer> res = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        res.put(nums[i], i);
      }
      return Collections.unmodifiableMap(res);
    }

    public List<List<Integer>> solve() {
      final Set<List<Integer>> res = new LinkedHashSet<>();
      final int size = sortedNums.length;
      for (int i = 0; i < size; i++) {
        for (int j = i + 1; j < size; j++) {
          int targetSum = sortedNums[i] + sortedNums[j];
          int maxIndexOfTarget = maxIndexOfTarget(-targetSum);
          if (maxIndexOfTarget > j) {
            res.add(Arrays.asList(sortedNums[i], sortedNums[j], sortedNums[maxIndexOfTarget]));
          }
        }
      }
      return Collections.unmodifiableList(new ArrayList<>(res));
    }

    private int[] sortedArray(int[] nums) {
      int[] numsCopy = Arrays.copyOf(nums, nums.length);
      Arrays.sort(numsCopy);
      return numsCopy;
    }

    private int maxIndexOfTarget(final int target) {
      return indexDict.getOrDefault(target, -1);
    }
  }
}
