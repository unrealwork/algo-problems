package com.leetcode.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntSupplier;

public class Triangle {
  private Triangle() {}

  public static int minimumTotal(List<List<Integer>> triangle) {
    return new Solver(triangle).solve();
  }

  private static class Solver {
    private final List<List<Integer>> triangle;
    private final Map<Integer, Map<Integer, Integer>> memo;

    private Solver(List<List<Integer>> triangle) {
      this.triangle = triangle;
      this.memo = new HashMap<>(triangle.size() + 1);
    }

    public int solve() {
      int min = solve(triangle.size() - 1, 0);
      for (int i = 1; i < triangle.size(); i++) {
        int res = solve(triangle.size() - 1, i);
        if (res < min) {
          min = res;
        }
      }
      return min;
    }

    private int solve(int row, int column) {
      if (column >= triangle.get(row).size() || column < 0) {
        return Integer.MAX_VALUE;
      }
      return memoize(
          row,
          column,
          () -> {
            if (row == 0) {
              return triangle.get(0).get(column);
            } else {
              final int nr = row - 1;
              return triangle.get(row).get(column)
                  + Math.min(solve(nr, column), solve(nr, column - 1));
            }
          });
    }

    private int memoize(int i, int j, IntSupplier resSupplier) {
      return memo.computeIfAbsent(i, k -> new HashMap<>())
          .computeIfAbsent(j, k -> resSupplier.getAsInt());
    }
  }
}
