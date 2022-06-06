package com.leetcode.ds.graph;

import java.util.ArrayDeque;
import java.util.Deque;

final class NumberOfIslands {
    private NumberOfIslands() {

    }

    public static int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        boolean[][] covered = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                boolean isLand = grid[i][j] == '1';
                if (!covered[i][j] && isLand) {
                    explore(i, j, grid, covered);
                    count++;
                }
            }
        }
        return count;
    }

    private static void explore(int i, int j, char[][] grid, boolean[][] covered) {
        Deque<int[]> next = new ArrayDeque<>();
        next.addLast(new int[] {i, j});
        while (!next.isEmpty()) {
            int[] last = next.removeLast();
            int curI = last[0];
            int curJ = last[1];
            boolean isValid = curI > -1 && curI < grid.length && curJ > -1 && curJ < grid[0].length;
            if (isValid && !covered[curI][curJ]) {
                covered[curI][curJ] = true;
                if (grid[curI][curJ] == '1') {
                    next.addLast(new int[] {curI + 1, curJ});
                    next.addLast(new int[] {curI, curJ + 1});
                    next.addLast(new int[] {curI - 1, curJ});
                    next.addLast(new int[] {curI, curJ - 1});
                }
            }
        }
    }

}
