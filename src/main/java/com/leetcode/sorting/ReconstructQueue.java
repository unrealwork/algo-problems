package com.leetcode.sorting;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ReconstructQueue {
    private ReconstructQueue() {

    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? -o1[0] + o2[0] : o1[1] - o2[1]);
        List<int[]> res = new ArrayList<>(people.length);
        for (int[] cur : people) {
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    }
}
