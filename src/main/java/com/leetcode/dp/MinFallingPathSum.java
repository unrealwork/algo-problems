package com.leetcode.dp;

import java.util.function.IntSupplier;

public class MinFallingPathSum {
  private MinFallingPathSum() {}

  public static int minFallingPathSum(int[][] matrix) {
    return new Solver(matrix).solve();
  }

  private static class Solver {
    private final int[][] matrix;
    private final Integer[][] memo;

    private Solver(int[][] matrix) {
      this.matrix = matrix;
      this.memo = new Integer[matrix.length + 1][matrix.length];
    }

    public int solve() {
      int min = solve(matrix.length - 1, 0, 0);
      for (int i = 1; i < matrix.length; i++) {
        int res = solve(matrix.length - 1, i, 0);
        if (res < min) {
          min = res;
        }
      }
      return min;
    }

    private int memoize(int i, int j, IntSupplier resSupplier) {
      if (memo[i][j] == null) {
        memo[i][j] = resSupplier.getAsInt();
      }
      return memo[i][j];
    }

    private int solve(int row, int column, int res) {
      if (column >= matrix.length || column < 0) {
        return Integer.MAX_VALUE;
      }
      return memoize(
          row,
          column,
          () -> {
            if (row == 0) {
              return matrix[0][column];
            } else {
              final int nr = row - 1;
              return matrix[row][column]
                  + Math.min(
                      solve(nr, column, res),
                      Math.min(solve(nr, column - 1, res), solve(nr, column + 1, res)));
            }
          });
    }
  }
}
