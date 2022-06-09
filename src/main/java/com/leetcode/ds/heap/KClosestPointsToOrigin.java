package com.leetcode.ds.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class KClosestPointsToOrigin {
    private KClosestPointsToOrigin() {
    }

    public static int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> reversed = Comparator
                .comparing((int[] p) -> p[0] * p[0] + p[1] * p[1])
                .reversed();
        PriorityQueue<int[]> heap = new PriorityQueue<>(reversed);
        Collections.addAll(heap, points);
        int[][] res = new int[k][];
        for (int i = 0; i < k && !heap.isEmpty(); i++) {
            res[i] = heap.remove();
        }
        return res;
    }
}
