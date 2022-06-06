package com.leetcode.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

final class MergeIntervals {
    private MergeIntervals() {

    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int[] base = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (isOverlap(base, intervals[i])) {
                base = merge(base, intervals[i]);
            } else {
                res.add(base);
                base = intervals[i];
            }
        }
        res.add(base);
        return res.toArray(new int[res.size()][2]);
    }


    static int[] merge(int[] i1, int[] i2) {
        return new int[] {Math.min(i1[0], i2[0]), Math.max(i1[1], i2[1])};
    }

    static boolean isOverlap(int[] i1, int[] i2) {
        if (i1[1] >= i2[0] && i1[1] <= i2[1]) {
            return true;
        }
        return i2[1] >= i1[0] && i2[1] <= i1[1];
    }
}
