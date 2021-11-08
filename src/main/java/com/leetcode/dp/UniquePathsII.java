package com.leetcode.dp;

public class UniquePathsII {
    private UniquePathsII() {
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean hasObstacle = hasObstacle(i, j, obstacleGrid);
                if (hasObstacle) {
                    dp[i][j] = (i > 0 ? dp[i - 1][j] : 0) + (j > 0 ? dp[i][j - 1] : 0);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    private static boolean hasObstacle(int i, int j, int[][] obstacleGrid) {
        return (i != 0 || j != 0) && obstacleGrid[i][j] != 1;
    }
}
