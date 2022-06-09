package com.leetcode.ds.graph;

import java.util.List;

class MinimumGraphTrees {
    private MinimumGraphTrees() {
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        boolean[][] graph = new boolean[n][n];
        int[][] dist = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            for (int j = 0; j < n; j++) {

            }
            dist[from][to] = 1;
            dist[to][from] = 1;

        }
        throw new UnsupportedOperationException();
    }
}
