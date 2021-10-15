package com.hackerrank.algorithms.dynamic;


import java.util.List;


public class CoinChangeProblem {
    public static long getWays(int n, List<Long> c) {
        long[][] res = new long[c.size()][n + 1];
        int[] coins = c.stream().mapToInt(Long::intValue)
                .sorted().toArray();
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
                    if (res[j][i] > 0) {
                        if (co + i <= n) {
                            res[k][co + i] += res[j][i];
                        }
                    }
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < coins.length; i++) {
            sum += res[i][n];
        }
        return sum;
    }
}
