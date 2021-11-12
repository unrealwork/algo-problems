package com.leetcode.dp;

import java.util.Arrays;

public class CoinChange {
    private CoinChange() {
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                int diff = i - coin;
                if (diff > -1 && dp[diff] > -1 && (dp[i] == -1 || dp[diff] + 1 < dp[i])) {
                    dp[i] = dp[diff] + 1;
                }
            }
        }
        return dp[amount];
    }
}
