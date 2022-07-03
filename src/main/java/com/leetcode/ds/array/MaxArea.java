package com.leetcode.ds.array;

import java.util.Arrays;

class MaxArea {
    private MaxArea() {
        
    }

    public static final int MODULO = 1000_000_007;

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        return (int) (findMaxSide(horizontalCuts, h) * findMaxSide(verticalCuts, w) % MODULO);
    }

    private static long findMaxSide(int[] cuts, int max) {
        Arrays.sort(cuts);
        int res = cuts.length > 0 ? Math.max(cuts[0], max - cuts[cuts.length - 1]) : max;
        for (int i = 1; i < cuts.length; i++) {
            res = Math.max(res, cuts[i] - cuts[i - 1]);
        }
        return res;
    }
}
