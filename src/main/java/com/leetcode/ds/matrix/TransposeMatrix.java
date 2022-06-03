package com.leetcode.ds.matrix;

/**
 * Given a 2D integer array matrix, return the <b>transpose</b> of matrix.
 * <br>
 * <a href="">Transpose Matrix</a>
 *
 * @author unrealwork
 */
final class TransposeMatrix {
    private TransposeMatrix() {

    }

    public static int[][] transpose(int[][] matrix) {
        int[][] res = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
