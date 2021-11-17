package com.leetcode.ds.array;

public class ReshapeMatrix {
    private ReshapeMatrix() {
        
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] res = new int[r][c];
        int index = 0;
        int resSize = r * c;
        for (int[] ints : mat) {
            for (int j = 0; j < ints.length; j++) {
                if (index < resSize) {
                    int resI = index / c;
                    res[resI][index - resI * c] = ints[j];
                }
                index++;
            }
        }
        if (resSize != index) {
            return mat;
        }
        return res;
    }
}
