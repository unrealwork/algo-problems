package com.hackerrank.algorithms.dynamic;

import java.util.List;

public class Knapsack {
    private Knapsack() {

    }

    public static int unboundedKnapsack(int n, List<Integer> arr) {
        // Write your code here
        int[] cache = new int[n + 1];
        int[] weights = arr.stream().mapToInt(Integer::intValue).toArray();
        return solve(0, n, weights, cache);
    }

    private static int solve(int currentSum, int limit, int[] weights, int[] cache) {
        if (cache[currentSum] > 0) {
            return currentSum;
        }
        if (currentSum == limit) {
            return limit;
        }
        int res = currentSum;
        for (int w : weights) {
            int nextSum = currentSum + w;
            if (nextSum <= limit) {
                nextSum = solve(nextSum, limit, weights, cache);
                if (nextSum > res) {
                    res = nextSum;
                }
            }
        }
        cache[currentSum] = res;
        return res;
    }
}
