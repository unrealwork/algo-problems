package com.leetcode.ds.array;

public class SetMatrixZeroes {
  private SetMatrixZeroes() {}

  public static void setZeroes(int[][] matrix) {
    if (matrix.length > 0) {
      ZeroCoverageChecker coverageChecker = new ZeroCoverageChecker(matrix);

      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
          if (coverageChecker.checkCell(i, j)) {
            matrix[i][j] = 0;
          }
        }
      }
    }
  }

  private static class ZeroCoverageChecker {
    private final boolean[] coveredRows;
    private final boolean[] coveredColumns;

    public ZeroCoverageChecker(int[][] matrix) {
      coveredRows = new boolean[matrix.length];
      coveredColumns = new boolean[matrix[0].length];
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
          if (matrix[i][j] == 0) {
            coveredRows[i] = true;
            coveredColumns[j] = true;
          }
        }
      }
    }

    public boolean checkCell(int i, int j) {
      return coveredRows[i] || coveredColumns[j];
    }
  }
}
