package com.leetcode.ds.matrix;

class NumMatrix {
    private final int[][] m;
    private final int[][] p;

    public NumMatrix(int[][] matrix) {
        this.m = matrix;
        this.p = prefixSums(m);
    }

    private int[][] prefixSums(int[][] m) {
        int[][] res = new int[m.length][];
        for (int i = 0; i < m.length; i++) {
            res[i] = new int[m[i].length];
            for (int j = 0; j < m[i].length; j++) {
                if (j == 0) {
                    res[i][j] = m[i][j];
                } else {
                    res[i][j] = res[i][j - 1] + m[i][j];
                }
            }
        }
        return res;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            if (row1 > 0) {
                sum += (p[i][col2] - p[i][col1 - 1]);
            } else {
                sum += p[i][col2];
            }
        }
        return sum;
    }
}
