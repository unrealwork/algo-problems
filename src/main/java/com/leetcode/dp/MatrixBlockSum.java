package com.leetcode.dp;

public class MatrixBlockSum {
    private MatrixBlockSum() {
    }

    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] ans = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                updateAnswer(mat, i, j, k, ans);
            }
        }
        return ans;
    }

    private static void updateAnswer(int[][] mat, int startI, int startJ, int k, int[][] ans) {
        int lowI = Math.min(0, startI - k);
        int upI = Math.min(mat.length, startI + k + 1);
        int lowJ = Math.min(0, startJ - k);
        int upJ = Math.min(mat[0].length, startJ + k + 1);
        for (int i = lowI; i < upI; i++) {
            for (int j = lowJ; j < upJ; j++) {
                ans[i][j] += mat[startI][startJ];
            }
        }
    }
}
