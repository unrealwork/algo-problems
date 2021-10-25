package com.leetcode.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntSupplier;

public class TargetSumTopDown {
  private TargetSumTopDown() {}

  public static int findTargetSumWays(int[] nums, int target) {
    return new Solver(nums, target).solve();
  }

  static class Solver {
    private final int[] nums;
    private final int target;
    private final Map<Integer, Map<Integer, Integer>> memo;

    Solver(int[] nums, int target) {
      this.nums = nums;
      this.target = target;
      this.memo = new HashMap<>();
    }

    public int solve() {
      return solve(0, 0);
    }

    private int solve(int sum, int currentIndex) {
      return memoize(
          currentIndex,
          sum,
          () -> {
            if (currentIndex == nums.length) {
              return sum == target ? 1 : 0;
            } else {
              return solve(sum + nums[currentIndex], currentIndex + 1)
                  + solve(sum - nums[currentIndex], currentIndex + 1);
            }
          });
    }

    private int memoize(int index, int sum, IntSupplier resSupplier) {
      return memo.computeIfAbsent(index, k -> new HashMap<>())
          .computeIfAbsent(sum, k -> resSupplier.getAsInt());
    }
  }
}
