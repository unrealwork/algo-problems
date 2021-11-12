package com.leetcode.dp;

public class CoinChangeII {
    private CoinChangeII() {
    }

    public static int change(int n, int[] coins) {
        if (n == 0) {
            return 1;
        }
        int[][] res = new int[coins.length][n + 1];
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            if (coin <= n) {
                res[i][coin] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int k = 0; k < coins.length; k++) {
                int co = coins[k];
                for (int j = 0; j <= k; j++) {
                    if (res[j][i] > 0 && co + i <= n) {
                        res[k][co + i] += res[j][i];
                    }
                }
            }
        }
        return sum(n, coins.length, res);
    }

    private static int sum(int n, int coinsSize, int[][] res) {
        int sum = 0;
        for (int i = 0; i < coinsSize; i++) {
            sum += res[i][n];
        }
        return sum;
    }
}
